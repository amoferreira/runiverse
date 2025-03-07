plugins {
    alias(libs.plugins.runiverse.jvm.library)
    alias(libs.plugins.kover)
}

dependencies {
    implementation(projects.core.domain)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    implementation(libs.faker)
}