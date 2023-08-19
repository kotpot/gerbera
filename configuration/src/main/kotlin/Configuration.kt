@file:Suppress("MemberVisibilityCanBePrivate")

package com.kotpot.configuration

import com.akuleshov7.ktoml.TomlInputConfig
import com.akuleshov7.ktoml.file.TomlFileReader
import com.kotpot.configuration.configs.ProjectConfiguration
import java.io.File


private val tomlReader = TomlFileReader(
    inputConfig = TomlInputConfig(
        ignoreUnknownNames = true,
    )
)

object Configuration {

    private const val FILE_NAME = "kotpot.toml"

    lateinit var project: ProjectConfiguration
        private set


    /**
     * Block to read configuration files.
     *
     * @param root The properties file root dir path. It should be path that only doesn't contain [FILE_NAME].
     *
     * @author korilin.dev@gmail.com
     */
    fun init(root: String) {
        val path = File(root, FILE_NAME).absolutePath
        val serializer = ProjectConfiguration.serializer()
        val tableName = ProjectConfiguration.TABLE_NAME
        project = tomlReader.partiallyDecodeFromFile(serializer, path, tableName)
    }

}
