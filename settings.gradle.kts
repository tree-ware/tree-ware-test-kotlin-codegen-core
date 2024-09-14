rootProject.name = "test-codegen-core"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
        mavenLocal() // TODO #### drop
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.tree-ware.core") {
                useModule("org.tree-ware.tree-ware-gradle-core-plugin:core-plugin:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            // TODO #### drop -SNAPSHOT
            val treeWareKotlinCoreVersion = version("treeWareKotlinCoreVersion", "0.3.0.0-SNAPSHOT")
            library("treeWareKotlinCore", "org.tree-ware.tree-ware-kotlin-core", "core").versionRef(
                treeWareKotlinCoreVersion
            )
            library(
                "treeWareKotlinCoreTestFixtures",
                "org.tree-ware.tree-ware-kotlin-core",
                "test-fixtures"
            ).versionRef(treeWareKotlinCoreVersion)
        }
    }
}