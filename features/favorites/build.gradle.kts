plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.favorites"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":data:products"))
}