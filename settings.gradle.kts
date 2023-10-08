pluginManagement {
    repositories {
        google()
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

rootProject.name = "android-navigation"
include(":app")
include(":data:categories")
include(":data:products")
include(":features:home")
include(":features:navigation-bar")
include(":features:product-card")
