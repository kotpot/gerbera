package com.kotpot.html.markdown

import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import java.io.File



fun htmlFromMd(mdFile: File): String {
    val content = mdFile.readText()
    val flavour = CommonMarkFlavourDescriptor()
    val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(content)
    return HtmlGenerator(content, parsedTree, flavour).generateHtml()
}
