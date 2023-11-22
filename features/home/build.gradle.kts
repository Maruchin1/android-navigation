plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.home"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":data:user"))
    implementation(project(":data:categories"))
    implementation(project(":data:products"))
}