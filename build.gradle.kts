plugins {
    kotlin("multiplatform") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.10"
}

group = "org.fengl"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



kotlin {

    val kotlin_date: String by project
    val serialization_version: String by project
    val mongoDb_driver_version: String by project
    val kbson_version: String by project

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serialization_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-cbor:$serialization_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:$serialization_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlin_date")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.mongodb:mongodb-driver-sync:$mongoDb_driver_version")
                implementation("com.github.jershell:kbson:$kbson_version")
            }
        }
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}
