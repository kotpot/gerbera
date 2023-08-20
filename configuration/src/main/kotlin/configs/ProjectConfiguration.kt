package com.kotpot.configuration.configs


class ProjectConfiguration(init: Map<String, Any>) : JsShareConfiguration(init) {

    val title: String? get() = property("title")

    val theme: String? get() = property("theme")

    val author: String? get() = property("author")

    // TODO ktoml isn't supported complex table/list+map structure.
    val links get() = property<List<Map<String, String>>>("link").orEmpty()

    companion object {
        internal const val TABLE_NAME = "project"
    }

}