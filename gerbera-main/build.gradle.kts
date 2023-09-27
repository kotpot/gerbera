import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

dependencies{
    implementation(project(":gerbera-configuration"))
    implementation(project(":gerbera-commands"))
    implementation(project(":gerbera-html"))
}

tasks.test {
    useJUnitPlatform()
}