@file:Suppress("FunctionName")

package com.kotpot.html.templates

import com.kotpot.configuration.Configuration
import com.kotpot.configuration.projectConfiguration
import com.kotpot.html.tag
import kotlinx.html.*
import kotlinx.html.stream.createHTML


fun HomeHeader() = createHTML().header {

    tag("title", projectConfiguration.title.orEmpty())

    meta("author", projectConfiguration.author)

    for (link in projectConfiguration.links) {
        link(rel = link["rel"], type = link["type"], href = link["href"])
    }

}
