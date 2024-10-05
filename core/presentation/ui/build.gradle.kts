plugins {
    alias(libs.plugins.runiverse.android.library.compose)
}

android {
    namespace = "com.amoferreira.core.presentation.ui"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    api(libs.androidx.compose.material3)

    // Project dependencies
    implementation(projects.core.domain)
    implementation(projects.core.presentation.designsystem)
}