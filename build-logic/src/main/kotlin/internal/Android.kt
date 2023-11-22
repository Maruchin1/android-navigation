package internal

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

internal inline fun <reified T : CommonExtension<*, *, *, *, *>> Project.configureAndroid() {
    with(pluginManager) {
        apply("org.jetbrains.kotlin.android")
        apply("org.jetbrains.kotlin.kapt")
    }

    extensions.configure<T> {
        compileSdk = 34

        defaultConfig {
            minSdk = 26
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    val kaptExtension = extensions.getByType<KaptExtension>()
    kaptExtension.apply {
        correctErrorTypes = true
    }
}