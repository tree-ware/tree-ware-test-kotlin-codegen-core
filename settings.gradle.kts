rootProject.name = "test-codegen-core"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.tree-ware.core") {
                useModule("org.tree-ware.tree-ware-gradle-core-plugin:org.tree-ware.core.gradle.plugin:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // TODO #### version
            val treeWareKotlinCoreVersion = version("treeWareKotlinCoreVersion", "generate-model-classes-SNAPSHOT")
            library("treeWareKotlinCore", "org.tree-ware.tree-ware-kotlin-core", "core").versionRef(
                treeWareKotlinCoreVersion
            )
        }
    }
}