plugins {
    alias(libs.plugins.runiverse.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}