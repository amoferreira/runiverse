plugins {
    alias(libs.plugins.runiverse.jvm.library)
    alias(libs.plugins.kover)
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)
}