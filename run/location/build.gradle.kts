plugins {
    alias(libs.plugins.runiverse.android.library)
}

android {
    namespace = "com.amoferreira.run.location"
}

dependencies {

    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.compose.material3)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    // Project dependencies
    implementation(projects.core.domain)
    implementation(projects.run.domain)
}