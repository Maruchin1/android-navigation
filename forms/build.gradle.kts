plugins {
    id("buildlogic.uimodule")
}

android {
    namespace = "com.maruchin.forms"
}

dependencies {
    implementation(project(":data:products"))
    implementation(project(":data:deliveries"))
    implementation(project(":data:payments"))
    implementation(project(":data:user"))
    implementation(project(":data:addresses"))
}