plugins {
    id("buildlogic.datamodule")
}

android {
    namespace = "com.maruchin.data.cart"
}

dependencies {
    api(project(":data:products"))
}