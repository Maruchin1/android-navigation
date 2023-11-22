plugins {
    id("buildlogic.datamodule")
}

android {
    namespace = "com.maruchin.data.order"
}

dependencies {
    api(project(":data:products"))
    api(project(":data:deliveries"))
    api(project(":data:cart"))
    api(project(":data:addresses"))
    api(project(":data:payments"))
}