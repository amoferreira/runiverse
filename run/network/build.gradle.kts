plugins {
    alias(libs.plugins.runiverse.android.library)
    alias(libs.plugins.runiverse.jvm.ktor)
}

android {
    namespace = "com.amoferreira.run.network"
}

dependencies {

    // Project dependencies
    implementation(projects.core.domain)
    implementation(projects.core.data)
}