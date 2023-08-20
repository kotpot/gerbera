package com.kotpot.configuration.configs

sealed class JsShareConfiguration(private val init: Map<String, Any>) : Map<String, Any> by init {

    protected inline fun <reified T> property(key: String): T? = get(key) as T?

    override fun toString(): String {
        return init.toString()
    }
}