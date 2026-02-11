import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.library)
    alias(libs.plugins.daylog.android.compose)
}

android {
    setNamespace("core.designsystem")
}

dependencies {
    implementation(libs.androidx.appcompat)

    implementation(libs.landscapist.bom)
    implementation(libs.landscapist.coil)
    implementation(libs.landscapist.placeholder)

    implementation(libs.androidx.glance)
}
