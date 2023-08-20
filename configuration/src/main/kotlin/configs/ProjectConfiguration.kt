package com.kotpot.configuration.configs


class ProjectConfiguration(init: Map<String, Any>) : JsShareConfiguration(init) {

    val title: String? get() = property("title")

    val theme: String? get() = property("theme")

    val author: String? get() = property("author")

    val metas get() = property<List<Map<String, String>>>("metas").orEmpty()

    val links get() = property<List<Map<String, String>>>("links").orEmpty()

    val scripts get() = property<List<Map<String, String>>>("scripts").orEmpty()

    companion object {
        internal const val TABLE_NAME = "project"
    }

}