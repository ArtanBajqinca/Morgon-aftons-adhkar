import com.android.build.api.dsl.Packaging

plugins {
    id("com.android.application")
    id("com.google.android.gms.oss-licenses-plugin")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "artan.bajqinca.morgon_afton_dhikr"
    compileSdk = 34

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }

    defaultConfig {
        applicationId = "artan.bajqinca.morgon_afton_dhikr"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = false

            // Ensure that licenses are generated for debug builds
            fun Packaging.() {
                resources.excludes.add("META-INF/LICENSE*")
            }
        }
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_20
        targetCompatibility = JavaVersion.VERSION_20
    }
    kotlinOptions {
        jvmTarget = "20"
    }
}

dependencies {
    val composeVersion = "1.6.4"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("io.github.jan-tennert.supabase:realtime-kt:1.4.0")
    implementation("io.ktor:ktor-client-okhttp:2.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha04")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.media3:media3-common:1.2.0")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("com.google.android.gms:play-services-oss-licenses:17.0.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}
