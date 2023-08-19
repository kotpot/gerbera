import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.kotlin.reflect)
    implementation(libs.ktoml.core)
    implementation(libs.ktoml.source)
    implementation(libs.ktoml.file)

}

tasks.test {
    useJUnitPlatform()
}