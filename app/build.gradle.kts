@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.serialization)
    kotlin("kapt")
}

android {
    namespace = "com.maruchin.androidnavigation"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.maruchin.androidnavigation"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":data:categories"))

    implementation(platform(libs.compose.bom))
    implementation(libs.androidx.core)
    implementation(libs.bundles.ui)
    implementation(libs.bundles.ktor)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    testImplementation(libs.bundles.test.unit)
}

kapt {
    correctErrorTypes = true
}