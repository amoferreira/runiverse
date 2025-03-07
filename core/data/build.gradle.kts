plugins {
    alias(libs.plugins.runiverse.android.library)
    alias(libs.plugins.runiverse.jvm.ktor)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.amoferreira.core.data"
}

dependencies {

    implementation(libs.timber)

    // Project dependencies
    implementation(projects.core.domain)
    implementation(projects.core.database)
}