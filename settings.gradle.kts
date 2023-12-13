println("This is executed during the initialization phase.")

// Define the location of plugins
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

// Can optionally define the location of components the project relies on
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}


// Define rootProject name. Equivalent to settings.rootProject.name
rootProject.name = "samDoesGradle"

include(":basics:basicJava")
include(":basics:basicKotlin")
include(":basics:buildLifecycle")
include(":basics:tasks")
include(":basics:writingTasks")

includeBuild("example-included-build")
// this is an example of how to have an included build

includeBuild("example-local-settings")
