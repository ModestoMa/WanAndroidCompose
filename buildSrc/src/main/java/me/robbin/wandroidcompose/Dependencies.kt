package me.robbin.wandroidcompose

/**
 * Description.
 * @author: Created by Robbin in 2021/3/31
 */
object Dependencies {

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val material = "com.google.android.material:material:1.3.0"
        const val paging = "androidx.paging:paging-compose:1.0.0-alpha08"

        object Compose {
            const val version = "1.0.0-beta05"
            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha05"
        }

        object Lifecycle {
            private const val version = "2.3.1"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha03"
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha05"
        }

    }

    object Net {

        object Coil {
            const val compose = "com.google.accompanist:accompanist-coil:0.7.0"
        }

        object Retrofit {
            private const val version = "2.9.0"
            const val core = "com.squareup.retrofit2:retrofit:$version"
            const val converter = "com.squareup.retrofit2:converter-moshi:$version"
            const val logger = "com.squareup.okhttp3:logging-interceptor:4.9.0"
        }

        object Moshi {
            private const val version = "1.12.0"
            const val android = "com.squareup.moshi:moshi:$version"
            const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
        }

    }

    object Kotlin {
        const val collections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.4"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3"
    }

}