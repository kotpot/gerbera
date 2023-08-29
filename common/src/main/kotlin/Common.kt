package com.kotpot.common

import org.jetbrains.annotations.TestOnly

@get:TestOnly
val curRootOnModuleTest: String get() = System.getProperty("user.dir") + "/.."

@get:TestOnly
const val testResourceDir = "test"

val curRoot: String get() = System.getProperty("user.dir")



