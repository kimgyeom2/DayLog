import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.feature)
    alias(libs.plugins.kotlin.android)
}

android {
    setNamespace("feature.main")
}

dependencies {
    implementation(project(":feature:home"))
    implementation(project(":feature:calendar"))
    implementation(project(":feature:profile"))
    implementation(project(":core:navigation"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.kotlinx.immutable)
}
