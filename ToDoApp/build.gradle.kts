// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

buildscript{
    dependencies{
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.56")
    }
}