plugins {
    alias(libs.plugins.runiverse.android.library)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.amoferreira.run.location"
}

dependencies {

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    // Project dependencies
    implementation(projects.core.domain)
    implementation(projects.run.domain)
}