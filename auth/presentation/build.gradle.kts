plugins {
    alias(libs.plugins.runiverse.android.feature.ui)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.amoferreira.auth.presentation"
}

dependencies {
    implementation(libs.timber)

    // Project dependencies
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}

kover {
    reports {
        filters {
            excludes {
                classes(
                    "*Preview*"
                )
                annotatedBy("*Generated*", "*Preview*")
            }
        }
    }
}