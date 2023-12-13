rootProject.name = "plugins"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

// Apply plugins
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

include(":binaryPlugins")
