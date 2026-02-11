import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.library)
}

android {
    setNamespace("core.network")
}

dependencies{
    implementation(libs.retrofit.v290)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
}