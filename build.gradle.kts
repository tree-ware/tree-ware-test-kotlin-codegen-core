import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.tree-ware.tree-ware-test-kotlin-codegen-core"
version = "0.5.0.0"

plugins {
    kotlin("multiplatform") version "2.1.10"
    id("idea")
    id("org.tree-ware.core") version "0.5.0.0"
    id("com.dorongold.task-tree") version "2.1.1" // for listing task dependencies
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

kotlin {
    jvm {
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.treeWareKotlinCore)
            implementation(kotlin("stdlib"))
        }
        commonTest.dependencies {
            implementation(libs.treeWareKotlinCoreTestFixtures)
            implementation(kotlin("test"))
        }
    }
}