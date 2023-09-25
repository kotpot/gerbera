@file:Suppress("MemberVisibilityCanBePrivate")

package com.kotpot.configuration

import com.kotpot.configuration.configs.ProjectConfiguration
import com.kotpot.configuration.configs.ThemeConfiguration
import com.kotpot.configuration.loader.TomlConfigLoader

object Configuration {

    lateinit var project: ProjectConfiguration
        private set

    lateinit var theme: ThemeConfiguration
        private set


    /**
     * Block to read configuration files.
     *
     * @param root The properties file root dir path. It should be path that only doesn't contain file name.
     *
     * @author korilin.dev@gmail.com
     */
    fun init(root: String) {
        val loader = TomlConfigLoader()
        loader.parse(root)
        project = loader.loadProjectConfiguration()
        theme = loader.loadThemeConfiguration()
    }
}

val projectConfiguration get() = Configuration.project
val themeConfiguration get() = Configuration.theme
