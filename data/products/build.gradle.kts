plugins {
    id("buildlogic.datamodule")
}

android {
    namespace = "com.maruchin.data.products"
}

dependencies {
    api(project(":data:categories"))
}