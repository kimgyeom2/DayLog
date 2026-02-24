import com.daylog.app.setNamespace


plugins {
    alias(libs.plugins.daylog.android.library)
}

setNamespace("core.datastore")

dependencies {
    implementation(libs.androidx.datastore)
    testImplementation(libs.junit4)
    testImplementation(libs.kotlin.test)
}