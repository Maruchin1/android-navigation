import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import internal.configureAndroid
import internal.configureCompose
import internal.configureHilt
import internal.configureNavigation
import internal.configureUnitTest
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AppModuleConventions : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.application")
        }

        extensions.configure<BaseAppModuleExtension> {
            defaultConfig {
                applicationId = "com.maruchin.androidnavigation"
                targetSdk = 34
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
            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }
        }

        configureAndroid<BaseAppModuleExtension>()
        configureHilt()
        configureCompose<BaseAppModuleExtension>()
        configureNavigation()
        configureUnitTest()
    }
}