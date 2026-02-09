import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.library)
}

android {
    setNamespace("core.network")
}

dependencies{
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
}