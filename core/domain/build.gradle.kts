import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.library)
}

android {
    setNamespace("core.domain")
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:datastore"))
}