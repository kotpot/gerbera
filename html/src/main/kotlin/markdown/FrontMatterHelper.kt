package com.kotpot.html.markdown

import cc.ekblad.toml.decode
import cc.ekblad.toml.tomlMapper

object FrontMatterHelper {


    private val tomlMapper = tomlMapper { }

    fun frontMatterAsString(lines: List<String>): ParseResult? {
        if (lines.isEmpty()) return null

        // Read first line as identified
        val type = FrontMatterType.entries.find {
            it.checkIdentified(lines.first())
        } ?: return null

        val builder = StringBuilder()

        for (index in 1..lines.lastIndex) {
            val line = lines[index]
            if (type.checkIdentified(line)) {
                // End of front matter
                return ParseResult(type, builder.toString(), index)
            } else {
                builder.append(line)
            }
            builder.append("\n")
        }

        // Uncaught closing with type
        return null
    }

    fun parseWithToml(frontMatter: String): Map<String, Any> {
        return tomlMapper.decode(frontMatter)
    }

    fun parseWithYaml(frontMatter: String): Map<String, Any> {
        TODO()
    }
}