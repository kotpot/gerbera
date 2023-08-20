package com.kotpot.html

import com.kotpot.common.ext.getBoolean
import com.kotpot.common.ext.getString
import kotlinx.html.*

@HtmlTagMarker
fun FlowOrMetaDataOrPhrasingContent.tag(name: String, content: String): Unit = HTMLTag(
    name, consumer, attributesMapOf(), null, inlineTag = false, emptyTag = false
).visit { text(content) }

context(FlowOrMetaDataOrPhrasingContent)
@HtmlTagMarker
fun Map<String, String>.toHtmlLink() = link {
    get("href")?.let { href = it }
    get("hrefLang")?.let { hrefLang = it }
    get("rel")?.let { rel = it }
    get("media")?.let { media = it }
    get("type")?.let { type = it }
    get("sizes")?.let { sizes = it }
    get("integrity")?.let { integrity = it }
}

context(FlowOrMetaDataOrPhrasingContent)
@HtmlTagMarker
fun Map<String, String>.toHtmlMeta() = meta {
    get("httpEquiv")?.let { httpEquiv = it }
    get("name")?.let { name = it }
    get("content")?.let { content = it }
    get("charset")?.let { charset = it }
}

context(FlowOrMetaDataOrPhrasingContent)
@HtmlTagMarker
fun Map<String, Any>.toHtmlScript() = script {
    getString("charset")?.let { charset = it }
    getString("type")?.let { type = it }
    getString("src")?.let { src = it }
    getBoolean("defer")?.let { defer = it }
    getBoolean("async")?.let { async = it }
    getString("nonce")?.let { nonce = it }
    getString("integrity")?.let { integrity = it }
}
