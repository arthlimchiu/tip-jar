pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TipJar"
include(":app")
include(":core:local")
include(":core:ui")
include(":feature:calculator")
include(":feature:savedpayments")
include(":core:model")
include(":core:data")
include(":core:common")
include(":utils:date")
include(":utils:currency")
include(":utils:bigdecimal")
