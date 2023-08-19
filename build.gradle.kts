import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

    tasks.withType<KotlinCompile>{
        kotlinOptions.jvmTarget = "17"
        kotlinOptions.freeCompilerArgs = listOf("-Xcontext-receivers")
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
    jvmToolchain(17)
}