plugins {
    kotlin("jvm") version "1.7.22"
    `kotlin-dsl`
    id("org.jetbrains.fleet") version "0.2-SNAPSHOT"
}

//val path = "/Users/ignatov/Library/Application Support/JetBrains/Toolbox/apps/Fleet/ch-0/1.13.76" +
//        "/Fleet.app/"

fleet {
    fleetPath.set("/Users/ignatov/Fleet/32261aa6f5d60-debug/Fleet.app/")

//    fleetPlugins {
//
//    }
//
//    frontend {
//        dependencies {
//
//        }
//    }
//
//    workspace {
//        dependencies {
//
//        }
//    }
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "17"
//    kotlinOptions.apiVersion = "1.7"
//    kotlinOptions.languageVersion = "1.7"
//}

repositories {
    jcenter()
    mavenLocal()
    mavenCentral()
    maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
}


