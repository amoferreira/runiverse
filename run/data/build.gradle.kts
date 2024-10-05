plugins {
    alias(libs.plugins.runiverse.android.library)
}

android {
    namespace = "com.amoferreira.run.data"
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)
    implementation(libs.androidx.work)
    testImplementation(libs.koin.android.workmanager)
    androidTestImplementation(libs.kotlinx.serialization.json)

    // Project dependencies
    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.run.domain)
}