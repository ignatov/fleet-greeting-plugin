repositories {
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}

plugins {
    kotlin("jvm") version "1.8.0"
    `kotlin-dsl`
    id("org.jetbrains.fleet-plugin") version "0.1.40"
}

version = "0.1.3"

fleet {
    fleetVersion.set("1.20.95")
    useNightlyBuilds.set(true)

    // presentation
    vendor.set("Sergey Ignatov")
    readableName.set("Fleet Greeting New Plugin")
    descriptor.set("A test plugin for Fleet")

    workspace {
        // workspace dependencies
        val ktorVersion = "2.2.0"
        implementation("io.ktor:ktor-client-core:$ktorVersion")
        implementation("io.ktor:ktor-client-java:$ktorVersion")
        implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
        implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    }

    frontend {
        // frontend dependencies
        implementation("org.twitter4j:twitter4j-core:4.1.1")
    }

    common {
        // common dependencies
        implementation("org.apache.samza:samza-shell:0.13.1")
    }

    // required plugins
    plugins.addAll("fleet.run")
}