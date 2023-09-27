package org.kotpot.gerbera.configuration.loader

import cc.ekblad.toml.decode
import cc.ekblad.toml.tomlMapper
import org.kotpot.gerbera.common.PROJECT_CONFIGURATION_FILE_NAME
import org.kotpot.gerbera.configuration.Configuration
import org.kotpot.gerbera.configuration.configs.ProjectConfiguration
import org.kotpot.gerbera.configuration.configs.ThemeConfiguration
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
        private const val FILE_NAME = "$PROJECT_CONFIGURATION_FILE_NAME.toml"
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
        val tableName = ThemeConfiguration.TABLE_NAME
        @Suppress("UNCHECKED_CAST")
        // TODO throw a friendly message exception
        // If theme table or theme name not found, note the theme must be specified.
        return ThemeConfiguration(map[tableName] as Map<String, Any>)
    }
}