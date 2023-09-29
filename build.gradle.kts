import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm) apply true
}

group = "org.kotpot.gerbera"
version = "1.0-SNAPSHOT"


allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()

        maven {
            // for 4koma
            url = uri("https://jitpack.io")
        }
    }
}

// TODO maybe a better way to keep it simple
subprojects {
    dependencies {
        // Fix implementation not found in this scope.
        apply(plugin = "kotlin")
        if (name != "gerbera-common") implementation(project(":gerbera-common"))

        // Tester
        testImplementation(kotlin("test"))
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