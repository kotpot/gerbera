pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "kotpot"

include(":gerbera-common")
include(":gerbera-commands")
include(":gerbera-html")
include(":gerbera-configuration")
include(":gerbera-main")
