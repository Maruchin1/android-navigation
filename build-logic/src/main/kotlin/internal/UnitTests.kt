package internal

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureUnitTest() {
    dependencies {
        add("testImplementation", getLibrary("junit"))
        add("testImplementation", getLibrary("kotlinx.coroutines.test"))
        add("testImplementation", getLibrary("turbine"))
    }
}