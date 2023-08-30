import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

dependencies{
    api(libs.kotlinx.coroutines.core)
}

tasks.test {
    useJUnitPlatform()
}