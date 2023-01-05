plugins {
    kotlin("jvm") version "1.7.22"
    `kotlin-dsl`
    id("org.jetbrains.fleet") version "0.2-SNAPSHOT"
}

fleet {
//    fleetPath.set("/Users/ignatov/Fleet/32261aa6f5d60-debug/Fleet.app/")
    fleetVersion.set("1.14.24")

//    fleetPlugins {
//
//    }
    frontend {
    }
    workspace {
    }
}

repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}