package com.kotpot.configuration.configs

sealed class JsShareConfiguration(init: Map<String, Any>) : HashMap<String, Any>(init) {

    protected inline fun <reified T> property(key: String): T? = get(key) as T?

}