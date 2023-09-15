package com.kotpot.configuration.loader

import cc.ekblad.toml.decode
import cc.ekblad.toml.tomlMapper
import com.kotpot.configuration.Configuration
import com.kotpot.configuration.configs.ProjectConfiguration
import com.kotpot.configuration.configs.ThemeConfiguration
import java.io.File


/**
 * Read configurations which in [Configuration] from toml tables.
 *
 * [parse] must be called first when load configurations,
 * such as [loadProjectConfiguration] and [loadThemeConfiguration],
 * because toml abstract syntax tree which [Configuration] depend on must be initialized
 * from toml file named [FILE_NAME].
 *
 * @author korilin.dev@gmail.com
 */
class TomlConfigLoader : ConfigurationLoader {

    companion object {
        private const val FILE_NAME = "kotpot.toml"
    }

    private val mapper = tomlMapper { }
    private lateinit var map: Map<String, Any>

    /**
     * Parse AST from toml file.
     */
    fun parse(path: String) {
        val file = File(path, FILE_NAME)
        map = mapper.decode(file.toPath())
    }

    override fun loadProjectConfiguration(): ProjectConfiguration {
        val tableName = ProjectConfiguration.TABLE_NAME
        @Suppress("UNCHECKED_CAST")
        return ProjectConfiguration(map[tableName] as Map<String, Any>)
    }

    override fun loadThemeConfiguration(): ThemeConfiguration {
        val themeName = Configuration.project.theme
        val tableName = ThemeConfiguration.themeTableBy(themeName)

        @Suppress("UNCHECKED_CAST")
        val value = map[tableName] as? Map<String, Any> ?: mapOf()
        return ThemeConfiguration(value)
    }
}