@file:Suppress("FunctionName")

package com.kotpot.html.templates

import com.kotpot.html.tag
import com.kotpot.html.toHtmlLink
import com.kotpot.html.toHtmlMeta
import com.kotpot.html.toHtmlScript
import kotlinx.html.*
import kotlinx.html.stream.createHTML


fun HomeHeader(
    title: String = "",
    author: String? = null,
    metas: List<Map<String, Any>> = emptyList(),
    links: List<Map<String, Any>> = emptyList(),
    scripts: List<Map<String, Any>> = emptyList(),
) = createHTML().header {

    tag("title", title.orEmpty())

    meta("author", author)

    for (meta in metas) {
        meta.toHtmlMeta()
    }

    for (link in links) {
        link.toHtmlLink()
    }

    for (script in scripts) {
        script.toHtmlScript()
    }
}
