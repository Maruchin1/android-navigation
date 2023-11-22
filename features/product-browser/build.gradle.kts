plugins {
    id("buildlogic.featuremodule")
    kotlin("kapt")
}

android {
    namespace = "com.maruchin.features.productbrowser"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":data:products"))
}