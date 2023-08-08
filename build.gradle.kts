plugins {
    kotlin("jvm") version "1.9.0"
}

group = "com.kotpot"
version = "1.0-SNAPSHOT"

val kotlin_version = "1.9.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")


}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}