plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "fr.nexa.billquote"
    compileSdk = 35

    defaultConfig {
        applicationId = "fr.nexa.billquote"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.annotation)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)

    // ✅ Retrofit for networking
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // ✅ Gson converter for JSON parsing
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // ✅ OkHttp logging (optional but useful for debugging)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
