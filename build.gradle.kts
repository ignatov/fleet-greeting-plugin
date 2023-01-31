plugins {
    kotlin("jvm") version "1.8.0"
    `kotlin-dsl`
    id("org.jetbrains.fleet") version "0.2-SNAPSHOT"
}

version = "0.1.0"

fleet {
//    fleetPath.set("/Users/ignatov/Fleet/87120b1bf721e-debug/Fleet.app")
    fleetVersion.set("1.15.24")
    useNightlyBuilds.set(true)

    workspace {
    }

    frontend {
        add("org.twitter4j:twitter4j-core:4.1.1")
    }

    common {
        add("org.apache.samza:samza-shell:0.13.1")
    }

    plugins.addAll("fleet.run")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}