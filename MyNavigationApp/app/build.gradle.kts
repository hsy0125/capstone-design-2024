// Apply the necessary plugins for the Android application
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    // Set the namespace for the application
    namespace = "com.example.navigation"

    // Define the compile SDK version
    compileSdk = 34

    defaultConfig {
        // Set the application ID
        applicationId = "com.example.navigation"

        // Define the minimum and target SDK versions
        minSdk = 24
        targetSdk = 34

        // Set the app version details
        versionCode = 1
        versionName = "1.0"

        // Specify the test instrumentation runner
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Enable vector drawables support
        vectorDrawables.useSupportLibrary = true
    }

    // Configure build types
    buildTypes {
        release {
            isMinifyEnabled = false
            // Specify ProGuard configuration files
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Configure compile options for Java
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // Configure Kotlin options
    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Enable Jetpack Compose
    buildFeatures {
        compose = true
    }

    // Set Kotlin compiler extension version for Compose
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    // Exclude unnecessary files from APK
    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
}

// Define the project dependencies
dependencies {
    // AndroidX Libraries
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.appcompat:appcompat:1.7.0-alpha03")

    // Google Maps SDK for Android
    implementation("com.google.android.gms:play-services-maps:17.0.1") // Google Maps SDK for Android
    implementation("com.google.android.gms:play-services-location:17.0.0") // 위치 관련 서비스

    // Retrofit for network calls (Optional, if you need to fetch OpenStreetMap data)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // JUnit for unit testing
    testImplementation("junit:junit:4.13.2")

    // Android Test Dependencies
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // JUnit for Android testing
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Espresso for UI testing
}
