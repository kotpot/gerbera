plugins {
    kotlin("jvm") version "1.9.0"
}

group = "com.kotpot"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation( "com.beust:jcommander:1.71")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}