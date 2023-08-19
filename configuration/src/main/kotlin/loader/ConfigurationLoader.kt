package com.kotpot.configuration.loader

import com.kotpot.configuration.configs.ProjectConfiguration
import com.kotpot.configuration.configs.ThemeConfiguration

sealed interface ConfigurationLoader {

    fun loadProjectConfiguration(): ProjectConfiguration

    fun loadThemeConfiguration(): ThemeConfiguration

}