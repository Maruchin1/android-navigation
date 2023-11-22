plugins {
    `kotlin-dsl`
}

group = "com.maruchin.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("dataModule") {
            id = "buildlogic.datamodule"
            implementationClass = "DataModuleConventions"
        }
        register("featureModule") {
            id = "buildlogic.featuremodule"
            implementationClass = "FeatureModuleConventions"
        }
        register("uiModule") {
            id = "buildlogic.uimodule"
            implementationClass = "UiModuleConventions"
        }
        register("appModule") {
            id = "buildlogic.appmodule"
            implementationClass = "AppModuleConventions"
        }
    }
}
