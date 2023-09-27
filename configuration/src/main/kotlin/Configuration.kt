@file:Suppress("MemberVisibilityCanBePrivate")

package org.kotpot.gerbera.configuration

import org.kotpot.gerbera.configuration.configs.ProjectConfiguration
import org.kotpot.gerbera.configuration.configs.ThemeConfiguration
import org.kotpot.gerbera.configuration.loader.TomlConfigLoader

class Configuration private constructor(
    val project: ProjectConfiguration,
    val theme: ThemeConfiguration
) {
    companion object {
        /**
         * Block to read configuration files.
         *
         * @param root The properties file root dir path. It should be path that only doesn't contain file name.
         *
         * @author korilin.dev@gmail.com
         */
        @JvmStatic
        fun init(root: String): Configuration {
            val loader = TomlConfigLoader()
            loader.parse(root)
            return Configuration(
                project = loader.loadProjectConfiguration(),
                theme = loader.loadThemeConfiguration()
            )
        }
    }
}
