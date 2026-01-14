import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.library)
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
