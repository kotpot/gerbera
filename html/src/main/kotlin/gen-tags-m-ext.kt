package com.kotpot.html

import kotlinx.html.*

@HtmlTagMarker
fun FlowOrMetaDataOrPhrasingContent.tag(name: String, content: String): Unit = HTMLTag(
    name, consumer, attributesMapOf(), null, inlineTag = false, emptyTag = false
).visit { text(content) }
