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
fun Map<String, Any>.toHtmlLink() = link {
    getString("href")?.let { href = it }
    getString("hrefLang")?.let { hrefLang = it }
    getString("rel")?.let { rel = it }
    getString("media")?.let { media = it }
    getString("type")?.let { type = it }
    getString("sizes")?.let { sizes = it }
    getString("integrity")?.let { integrity = it }
}

context(FlowOrMetaDataOrPhrasingContent)
@HtmlTagMarker
fun Map<String, Any>.toHtmlMeta() = meta {
    getString("httpEquiv")?.let { httpEquiv = it }
    getString("name")?.let { name = it }
    getString("content")?.let { content = it }
    getString("charset")?.let { charset = it }
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
