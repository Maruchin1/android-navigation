plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.order"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":forms"))
    implementation(project(":data:order"))
}