pluginManagement {
    includeBuild("build-logic")
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

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "DayLog"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")

include(
    ":app-config:app-config",
    ":app-config:app-config-api",
)

// core
include(
    ":core:designsystem",
    ":core:domain",
    ":core:data",
    ":core:common",
    ":core:navigation",
    ":core:network"
)

// Feature
include(
    ":feature:main",
    ":feature:login",
    ":feature:home",
    ":feature:calendar",
    ":feature:profile"
)



include(":app:baselineprofile")

include(":baselineprofile")
