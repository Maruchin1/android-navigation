plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.maruchin.features.mydata"
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":forms"))
    implementation(project(":data:user"))
    implementation(project(":data:addresses"))
}