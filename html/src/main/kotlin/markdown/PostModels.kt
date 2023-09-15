package com.kotpot.html.markdown


enum class FrontMatterType(private val identified: String) {
    Toml("+++"), Yaml("---");

    fun checkIdentified(line: String): Boolean = line == identified
}

data class ParseResult(
    val type: FrontMatterType,
    val content: String,
    val endLine: Int
)