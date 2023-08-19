package com.kotpot.configuration.configs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectConfiguration(
    @SerialName("project_name")
    var projectName: String? = null
): JsShareConfiguration() {

    companion object {
        internal const val TABLE_NAME = "project"
    }

}