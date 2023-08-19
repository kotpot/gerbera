plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "com.kotpot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.kotlin.reflect)
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.9.1")
}

tasks.test {
    useJUnitPlatform()
}