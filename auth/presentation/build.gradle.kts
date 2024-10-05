plugins {
    alias(libs.plugins.runiverse.android.feature.ui)
}

android {
    namespace = "com.amoferreira.auth.presentation"
}

dependencies {

    // Project dependencies
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}