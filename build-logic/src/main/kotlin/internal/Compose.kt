package internal

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal inline fun <reified T : CommonExtension<*, *, *, *, *>> Project.configureCompose() {
    extensions.configure<T> {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.4.3"
        }
    }

    dependencies {
        add("implementation", platform(getLibrary("compose.bom")))
        add("implementation", getLibrary("compose.ui"))
        add("implementation", getLibrary("compose.graphics"))
        add("implementation", getLibrary("compose.preview"))
        add("implementation", getLibrary("compose.material"))
        add("implementation", getLibrary("compose.icons"))
        add("implementation", getLibrary("coil.compose"))
        add("implementation", getLibrary("androidx.lifecycle"))
        add("implementation", getLibrary("androidx.activity"))
        add("implementation", getLibrary("androidx.browser"))
        add("debugImplementation", getLibrary("compose.ui.tooling"))
    }
}