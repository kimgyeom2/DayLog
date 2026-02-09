import com.daylog.app.filterProject

plugins {
    alias(libs.plugins.daylog.android.application)
    id("com.google.android.gms.oss-licenses-plugin")
    alias(libs.plugins.baselineprofile)
    alias(libs.plugins.roborazzi.plugin)
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.daylog.app"

    defaultConfig {
        applicationId = "com.daylog.app"
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    rootProject.subprojects.filterProject {
        if (it.name.contains("baselineprofile")) {
            baselineProfile(it)
        } else if (it.name.contains("testing")) {
            testImplementation(it)
        } else {
            implementation(it)
        }
    }
    implementation(libs.androidx.profileinstaller)
    implementation(project(":feature:login"))
    implementation(project(":feature:main"))
    implementation(libs.androidx.navigation.runtime.android)
    implementation(libs.appcompat)
    "baselineProfile"(project(":baselineprofile"))
}
