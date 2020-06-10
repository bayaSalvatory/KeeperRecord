package com.keeper.buildsrc

object Dependencies {

    object Fragment {
        private const val version = "1.2.0-alpha02"
        const val fragment = "androidx.fragment:fragment:$version"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
    }

    object Koin {
        private const val version = "2.0.1"
        const val koin = "org.koin:koin-android:$version"
        const val koinScope = "org.koin:koin-androidx-scope:$version"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:$version"
    }
}