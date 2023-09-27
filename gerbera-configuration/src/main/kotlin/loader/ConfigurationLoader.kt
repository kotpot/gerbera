package org.kotpot.gerbera.configuration.loader

import org.kotpot.gerbera.configuration.configs.ProjectConfiguration
import org.kotpot.gerbera.configuration.configs.ThemeConfiguration

sealed interface ConfigurationLoader {

    fun loadProjectConfiguration(): ProjectConfiguration

    fun loadThemeConfiguration(): ThemeConfiguration

}