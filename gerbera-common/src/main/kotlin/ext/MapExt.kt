package org.kotpot.gerbera.common.ext


fun Map<String, Any>.getString(key: String) = get(key) as? String
fun Map<String, Any>.getBoolean(key: String) = get(key) as? Boolean

