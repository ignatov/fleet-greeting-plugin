// this block is only needed because the repo is private to us for now
val spaceUsername: String by project
val spacePassword: String by project
repositories {
  mavenCentral()
  maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
  maven {
    url = uri("https://packages.jetbrains.team/maven/p/fleet/fleet-sdk")
    credentials {
      username = spaceUsername
      password = spacePassword
    }
  }
}

plugins {
    kotlin("jvm") version "1.8.0"
    `kotlin-dsl`
    id("org.jetbrains.fleet-plugin") version "0.1.10"
}

version = "0.1.2"

fleet {
//    fleetPath.set("/Users/ignatov/Fleet/183356a708cd4-debug/Fleet.app/")
    fleetVersion.set("1.15.34")
    useNightlyBuilds.set(true)

    workspace {
        val ktorVersion = "2.2.0"
        implementation("io.ktor:ktor-client-core:$ktorVersion")
        implementation("io.ktor:ktor-client-java:$ktorVersion")
        implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
        implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    }

    frontend {
        implementation("org.twitter4j:twitter4j-core:4.1.1")
    }

    common {
        implementation("org.apache.samza:samza-shell:0.13.1")
    }

    vendor.set("Sergey Ignatov")
    readableName.set("Fleet Greeting New Plugin")
    descriptor.set("A test plugin for Fleet")

    plugins.addAll("fleet.run")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}