package com.kotpot.configuration.configs


class ProjectConfiguration(init: Map<String, Any>) : JsShareConfiguration(init) {

    val projectName: String? get() = property("project_name")

    val theme: String? get() = property("theme")

    companion object {
        internal const val TABLE_NAME = "project"
    }

}