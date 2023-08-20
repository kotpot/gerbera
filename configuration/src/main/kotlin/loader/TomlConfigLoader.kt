package com.kotpot.configuration.loader

import com.akuleshov7.ktoml.TomlInputConfig
import com.akuleshov7.ktoml.parsers.TomlParser
import com.akuleshov7.ktoml.tree.nodes.TomlFile
import com.akuleshov7.ktoml.tree.nodes.TomlKeyValuePrimitive
import com.akuleshov7.ktoml.tree.nodes.TomlTable
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

    private val inputConfig = TomlInputConfig(
        ignoreUnknownNames = true
    )

    private val parser = TomlParser(inputConfig)

    private lateinit var ast: TomlFile

    /**
     * Parse AST from toml file.
     */
    fun parse(path: String) {
        val file = File(path, FILE_NAME)
        val content = file.readText()
        ast = parser.parseString(content)
    }

    private fun convertTableToMap(table: TomlTable): Map<String, Any> {
        val map = mutableMapOf<String, Any>()
        table.children.forEach {
            if (it is TomlKeyValuePrimitive) {
                map[it.name] = it.value.content
            }
            if (it is TomlTable) {
                map[it.name] = convertTableToMap(it)
            }
        }
        return map
    }

    override fun loadProjectConfiguration(): ProjectConfiguration {
        val tableName = ProjectConfiguration.TABLE_NAME
        val table = ast.findTableInAstByName(tableName)!!
        val map = convertTableToMap(table)
        return ProjectConfiguration(map)
    }

    override fun loadThemeConfiguration(): ThemeConfiguration {
        val themeName = Configuration.project.theme
        val tableName = ThemeConfiguration.themeTableBy(themeName)
        val table = ast.findTableInAstByName(tableName)!!
        val map = convertTableToMap(table)
        return ThemeConfiguration(map)
    }
}