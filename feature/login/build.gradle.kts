import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.feature)
    alias(libs.plugins.kotlin.android)
}

android {
    setNamespace("feature.login")
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
}
