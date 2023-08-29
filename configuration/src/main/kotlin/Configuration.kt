@file:Suppress("MemberVisibilityCanBePrivate")

package com.kotpot.configuration

import com.kotpot.common.curRoot
import com.kotpot.common.curRootOnModuleTest
import com.kotpot.common.testResourceDir
import com.kotpot.configuration.configs.ProjectConfiguration
import com.kotpot.configuration.configs.ThemeConfiguration
import com.kotpot.configuration.loader.TomlConfigLoader
import org.jetbrains.annotations.TestOnly
import java.io.File

object Configuration {

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
        val loader = TomlConfigLoader()
        loader.parse(root)
        project = loader.loadProjectConfiguration()
        theme = loader.loadThemeConfiguration()
    }


    @TestOnly
    fun initWhenModelTest() {
        val file = File(curRootOnModuleTest, testResourceDir)
        init(file.absolutePath)
        println(project)
        println(theme)
    }

    @TestOnly
    fun initWhenProjectTest() {
        val file = File(curRoot, testResourceDir)
        init(file.absolutePath)
        println(project)
        println(theme)
    }
}

val projectConfiguration get() = Configuration.project
val themeConfiguration get() = Configuration.theme
