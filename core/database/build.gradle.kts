plugins {
    alias(libs.plugins.runiverse.android.library)
    alias(libs.plugins.runiverse.android.room)
    alias(libs.plugins.kover)
}

android {
    namespace = "com.amoferreira.core.database"
}

dependencies {

    implementation(libs.org.mongodb.bson)

    // Project dependencies
    implementation(projects.core.domain)
}