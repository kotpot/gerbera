package com.kotpot.configuration.configs

class ThemeConfiguration(init: Map<String, Any>) : JsShareConfiguration(init)  {

    companion object {

        private const val DEFAULT_THEME = "kotpot"

        fun themeTableBy(theme: String?) = "theme-${theme ?: DEFAULT_THEME}"
    }

}