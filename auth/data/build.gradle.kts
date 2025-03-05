plugins {
    alias(libs.plugins.runiverse.android.library)
    alias(libs.plugins.runiverse.jvm.ktor)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.amoferreira.auth.data"
}

dependencies {
    implementation(libs.bundles.koin)

    // Project dependencies
    implementation(projects.auth.domain)
    implementation(projects.core.domain)
    implementation(projects.core.data)
}