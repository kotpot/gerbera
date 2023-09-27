import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.kotpot.gerbera"
version = "1.0-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.kotlin.reflect)
    implementation(project(":configuration"))
}

allprojects {


    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()

        maven {
            url = uri("https://jitpack.io")
        }
    }

    dependencies {
        // Fix implementation not found in this scope.
        apply(plugin = "kotlin")
        if (name != "common") implementation(project(":common"))
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
        kotlinOptions.freeCompilerArgs = listOf("-Xcontext-receivers")
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}