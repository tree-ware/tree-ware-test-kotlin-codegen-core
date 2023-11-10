import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.tree-ware.tree-ware-test-kotlin-codegen-core"
version = "0.1.0.0"

plugins {
    kotlin("multiplatform") version "1.7.0"
    id("idea")
    // TODO #### version
    id("org.tree-ware.core") version "0.1.0.0"
// TODO #### used with plugin from jitpack //    id("org.tree-ware.core") version "generate-diagrams-SNAPSHOT"
    id("com.dorongold.task-tree") version "2.1.1" // for listing task dependencies
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    mavenLocal() // TODO #### remove
}

tasks.withType<KotlinCompile> {
    // Compile for Java 8 (default is Java 6)
    kotlinOptions.jvmTarget = "1.8"
}

kotlin {
    jvm {
        withJava()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.treeWareKotlinCore)
                implementation(kotlin("stdlib"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.treeWareKotlinCoreTestFixtures)
                implementation(kotlin("test"))
            }
        }
    }
}