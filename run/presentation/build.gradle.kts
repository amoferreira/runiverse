plugins {
    alias(libs.plugins.runiverse.android.feature.ui)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.amoferreira.run.ui"
}

dependencies {

    implementation(libs.coil.compose)
    implementation(libs.google.maps.android.compose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.timber)

    // Project dependencies
    implementation(projects.core.domain)
    implementation(projects.run.domain)
}