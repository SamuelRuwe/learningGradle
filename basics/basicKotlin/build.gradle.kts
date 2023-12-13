plugins {
    kotlin("jvm") version "1.9.0"
    id("org.puregeniusness.my-binary-plugin")
    id("puregeniusness.example")
}

group = "org.puregeniusness"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

tasks.test {
    useJUnitPlatform()
}
