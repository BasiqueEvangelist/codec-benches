plugins {
    id("java")
    id("me.champeau.jmh") version "0.7.2"
}

group = "me.basiqueevangelist"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://maven.wispforest.io")
    maven(url = "https://maven.lukebemish.dev/releases")
    maven(url = "https://libraries.minecraft.net")
}

dependencies {
    implementation("com.mojang:datafixerupper:7.0.14")
    implementation("dev.lukebemish:codecextras:2.2.1")
    implementation("io.wispforest:endec:0.1.3")
    implementation("io.wispforest.endec:gson:0.1.2")
    implementation("io.wispforest.endec:netty:0.1.2")
    implementation("io.wispforest.endec:jankson:0.1.2")
    implementation("io.netty:netty-buffer:4.1.97.Final")
    implementation("blue.endless:jankson:1.2.2")
}

jmh {
    fork = 1
}
