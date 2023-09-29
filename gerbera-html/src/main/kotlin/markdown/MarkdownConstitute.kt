package org.kotpot.gerbera.html.markdown

import cc.ekblad.toml.decode
import cc.ekblad.toml.tomlMapper
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.io.File
import kotlin.text.StringBuilder

data class MarkdownConstitute(
    val frontMatter: Map<String, Any>,
    val postContent: String
) {

    companion object {
        fun parse(markdown: File): MarkdownConstitute {
            val lines = markdown.readLines()
            val result = FrontMatterHelper.frontMatterAsString(lines) ?: return parse(lines)
            return parse(result, lines)
        }

        private fun parse(lines: List<String>): MarkdownConstitute {
            val postContent = lines.asHtml(0)
            return MarkdownConstitute(emptyMap(), postContent)
        }

        private fun parse(result: ParseResult, lines: List<String>): MarkdownConstitute {
            val frontMatter = when (result.type) {
                FrontMatterType.Toml -> FrontMatterHelper.parseWithToml(result.content)
                FrontMatterType.Yaml -> FrontMatterHelper.parseWithYaml(result.content)
            }
            val postContent = lines.asHtml(result.endLine + 1)
            return MarkdownConstitute(frontMatter, postContent)
        }

        private fun List<String>.asHtml(start: Int): String {
            val builder = java.lang.StringBuilder()
            for (index in start..lastIndex) {
                builder.append(get(index))
                builder.append("\n")
            }
            val content = builder.toString()
            val flavour = CommonMarkFlavourDescriptor()
            val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(content)
            return HtmlGenerator(content, parsedTree, flavour).generateHtml()
        }
    }
}