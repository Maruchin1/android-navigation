import com.android.build.api.dsl.LibraryExtension
import internal.configureAndroid
import internal.configureHilt
import internal.configureUnitTest
import org.gradle.api.Plugin
import org.gradle.api.Project

class DataModuleConventions : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
        }

        configureAndroid<LibraryExtension>()
        configureHilt()
        configureUnitTest()
    }
}