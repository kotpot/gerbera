import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.fkoma)
    implementation(libs.kotlinx.html.jvm)
    implementation(libs.intellij.markdown)
    implementation(libs.thymeleaf)
}

tasks.test {
    useJUnitPlatform()
}