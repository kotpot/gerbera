plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "com.kotpot"
version = "1.0-SNAPSHOT"

allprojects {

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.kotlin.reflect)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}