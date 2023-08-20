@file:Suppress("FunctionName")

package com.kotpot.html.templates

import com.kotpot.configuration.projectConfiguration
import com.kotpot.html.tag
import com.kotpot.html.toHtmlLink
import com.kotpot.html.toHtmlMeta
import com.kotpot.html.toHtmlScript
import kotlinx.html.*
import kotlinx.html.stream.createHTML


fun HomeHeader() = createHTML().header {

    tag("title", projectConfiguration.title.orEmpty())

    meta("author", projectConfiguration.author)

    for (meta in projectConfiguration.metas) {
        meta.toHtmlMeta()
    }

    for (link in projectConfiguration.links) {
        link.toHtmlLink()
    }

    for (script in projectConfiguration.scripts) {
        script.toHtmlScript()
    }
}
