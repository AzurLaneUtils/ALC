buildscript {
    repositories {
        maven(url = "https://mirrors.huaweicloud.com/repository/maven")
        mavenCentral()
        jcenter()
        google()
    }
}

plugins {
    kotlin("jvm") version "1.4.10"
    id("org.jetbrains.dokka") version "1.4.20"
}

allprojects {
    group = "org.alu"
    version = "0.1.0"

    repositories {
        maven(url = "https://mirrors.huaweicloud.com/repository/maven")
        mavenCentral()
        jcenter()
        google()
    }
}
