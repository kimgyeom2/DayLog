import com.daylog.app.setNamespace

plugins {
    alias(libs.plugins.daylog.android.library)
}

android {
    setNamespace("core.model")
}