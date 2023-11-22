plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.profile"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":data:user"))
    implementation(project(":data:promotions"))
}