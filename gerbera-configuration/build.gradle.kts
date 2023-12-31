import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.fkoma)
}

tasks.test {
    useJUnitPlatform()
}