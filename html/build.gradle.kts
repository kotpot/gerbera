import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlinx.html.jvm)
    implementation(libs.intellij.markdown)
}

tasks.test {
    useJUnitPlatform()
}