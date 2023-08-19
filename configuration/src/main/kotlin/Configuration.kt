@file:Suppress("MemberVisibilityCanBePrivate")

package com.kotpot.configuration

import com.kotpot.configuration.configs.ProjectConfiguration
import com.kotpot.configuration.configs.ThemeConfiguration
import com.kotpot.configuration.loader.ConfigurationLoader
import com.kotpot.configuration.loader.TomlConfigLoader
import java.io.File

object Configuration {

    private const val FILE_NAME = "kotpot.toml"

    lateinit var project: ProjectConfiguration
        private set

    lateinit var theme: ThemeConfiguration
        private set


    /**
     * Block to read configuration files.
     *
     * @param root The properties file root dir path. It should be path that only doesn't contain [FILE_NAME].
     *
     * @author korilin.dev@gmail.com
     */
    fun init(root: String) {
        val file = File(root, FILE_NAME)
        val loader = TomlConfigLoader()
        loader.parse(file)
        project = loader.loadProjectConfiguration()
        theme = loader.loadThemeConfiguration()
    }
}
