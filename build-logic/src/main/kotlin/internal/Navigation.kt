package internal

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureNavigation() {
    dependencies {
        add("implementation", getLibrary("hilt.navigation.compose"))
        add("implementation",getLibrary("compose.navigation"))
    }
}