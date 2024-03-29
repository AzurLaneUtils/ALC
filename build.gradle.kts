buildscript {
    repositories {
        maven(url = "https://mirrors.huaweicloud.com/repository/maven")
//        mavenCentral()
//        google()
//        jcenter()
    }
}

plugins {
    kotlin("jvm") version "1.4.32"
    id("org.jetbrains.dokka") version "1.4.32"
}

allprojects {
    group = "org.alu"
    version = "0.1.202107"

    repositories {
        maven(url = "https://mirrors.huaweicloud.com/repository/maven")
//        mavenCentral()
//        google()
//        jcenter()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}
