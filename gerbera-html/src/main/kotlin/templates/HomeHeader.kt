@file:Suppress("FunctionName")

package org.kotpot.gerbera.html.templates

import org.kotpot.gerbera.html.tag
import org.kotpot.gerbera.html.toHtmlLink
import org.kotpot.gerbera.html.toHtmlMeta
import org.kotpot.gerbera.html.toHtmlScript
import kotlinx.html.*
import kotlinx.html.stream.createHTML


fun HomeHeader(
    title: String = "",
    author: String? = null,
    metas: List<Map<String, Any>> = emptyList(),
    links: List<Map<String, Any>> = emptyList(),
    scripts: List<Map<String, Any>> = emptyList(),
) = createHTML().header {

    tag("title", title)

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
