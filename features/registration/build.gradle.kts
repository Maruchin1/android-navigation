plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.registration"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":forms"))
    implementation(project(":data:user"))
}