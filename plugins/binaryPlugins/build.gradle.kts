plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("myBinaryPlugin") {
            id = "org.puregeniusness.my-binary-plugin"
            implementationClass = "org.puregeniusness.MyBinaryPlugin"
        }
    }
}
