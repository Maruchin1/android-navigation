plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.cart"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":data:cart"))
    implementation(project(":data:order"))
}