plugins {
    id("buildlogic.appmodule")
}

android {
    namespace = "com.maruchin.androidnavigation"
}

dependencies {
    implementation(project(":ui"))

    implementation(project(":features:home"))
    implementation(project(":features:category-browser"))
    implementation(project(":features:product-browser"))
    implementation(project(":features:product-card"))
    implementation(project(":features:login"))
    implementation(project(":features:profile"))
    implementation(project(":features:my-data"))
    implementation(project(":features:registration"))
    implementation(project(":features:cart"))
    implementation(project(":features:order"))
    implementation(project(":features:favorites"))
}
