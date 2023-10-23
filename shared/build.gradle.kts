val ktorVersion = "2.3.2"
val sqlDelightVersion = "2.0.0"
val koinVersion = "3.1.2"

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.10"
    id("app.cash.sqldelight") version "2.0.0-rc01"
    id("org.jlleitschuh.gradle.ktlint")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.koin.core)
                implementation(libs.runtime)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.android)
                implementation(libs.sqldelight.android.driver)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
                implementation(libs.sqldelight.native.driver)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    namespace = "com.example.githubusersloader"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
}
dependencies {
    implementation(libs.firebase.firestore.ktx)
}

sqldelight{
    databases{
        create("AppDatabase"){
            packageName.set("com.example.application.database")
        }
    }
}
