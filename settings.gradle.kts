println("This is executed during the initialization phase.")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "samDoesGradle"
include(":basics:basicJava")
include(":basics:basicKotlin")
include(":basics:buildLifecycle")
