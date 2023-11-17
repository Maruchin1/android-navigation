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

include(":features:home")
include(":features:category-browser")
include(":features:product-browser")
include(":features:product-card")
include(":features:login")
include(":features:profile")
include(":features:my-data")
include(":features:registration")
include(":features:cart")
include(":features:order")
include(":features:favorites")

include(":data:categories")
include(":data:products")
include(":data:user")
include(":core:intent")
include(":data:promotions")
include(":data:addresses")
include(":data:cart")
include(":data:deliveries")
include(":data:order")
include(":data:payments")

include(":core:ui")
include(":core:forms")
