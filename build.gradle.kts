import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.tree-ware.tree-ware-test-kotlin-codegen-core"
version = "0.1.0.0"

plugins {
    kotlin("jvm") version "1.7.0"
    id("idea")
    // TODO #### version
    id("org.tree-ware.core") version "generate-diagrams-SNAPSHOT"
}

treeWare {
    codegenDirectory.set("generated")
    metaModel {
        files.add("src/main/resources/metaModel/address_book_root.json")
        files.add("src/main/resources/metaModel/address_book_main.json")
        files.add("src/main/resources/metaModel/address_book_city.json")
        files.add("src/main/resources/metaModel/geo.json")
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

tasks.withType<KotlinCompile> {
    // Compile for Java 8 (default is Java 6)
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(libs.treeWareKotlinCore)
    implementation(kotlin("stdlib"))
}