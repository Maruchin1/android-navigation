plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.categorybrowser"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":data:categories"))
}