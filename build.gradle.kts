buildscript {
    dependencies {
        classpath(libs.gradle.plugin)
    }
}

plugins {
    // trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.ktLint)
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
