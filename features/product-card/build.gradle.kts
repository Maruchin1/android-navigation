plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.productcard"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":data:products"))
    implementation(project(":data:cart"))
}