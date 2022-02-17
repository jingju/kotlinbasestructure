package com.ht.build

/**
 * 依赖管理
 */
object DependencyConfig {

    object Version {
        // AndroidX--------------------------------------------------------------
        const val MultiDex = "2.0.1"
        const val Coil = "1.2.1"
        const val ConstraintLayout = "2.0.4"
        const val VectorDrawable = "1.1.0"

        // JetPack---------------------------------------------------------------
        const val Paging = "3.0.0-beta01"
        const val Room = "2.3.0"
        const val Viewpager = "1.0.0"
        const val Navigation = "2.3.5"

        // Kotlin----------------------------------------------------------------
        const val Coroutines = "1.5.2"
        const val Koin = "2.2.0-rc-3"
        const val CoreKtx = "1.3.2"
        const val Appcompat = "1.2.0"
        const val Material = "1.3.0"
        const val Junit = "4.12"
        const val ExtJunit = "1.1.2"
        const val EspressoCore = "3.3.0"

        // GitHub----------------------------------------------------------------
        const val Gson = "2.8.6"
        const val LiveDataBus = "1.8.0"
        const val Okhttp = "4.9.0"
        const val Retrofit = "2.9.0"
        const val Logger = "2.2.0"
        const val Lottie = "2.7.0"
        const val LoadSir = "1.3.8"
        const val ArouterApi = "1.5.0"
        const val ArouterCompilerKapt = "1.2.2"
        const val RefreshLayout = "2.0.3"
        const val MMKV = "1.2.12"
    }

    object AndroidX {
        //
        const val CoreKtx = "androidx.core:core-ktx:${Version.CoreKtx}"
        const val Appcompat = "androidx.appcompat:appcompat:${Version.Appcompat}"
        const val Material = "com.google.android.material:material:${Version.Material}"
        const val Junit = "junit:junit:${Version.Junit}"
        const val ExtJunit = "androidx.test.ext:junit:${Version.ExtJunit}"
        const val EspressoCore = "androidx.test.espresso:espresso-core:${Version.EspressoCore}"

        //multidex
        const val Multidex = "androidx.multidex:multidex:${Version.MultiDex}"

        //coil---
        const val Coil = "io.coil-kt:coil:${Version.Coil}"

        //ConstraintLayout
        const val ConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}"

        //vectorDrawable---
        const val VectorDrawable =
            "androidx.vectordrawable:vectordrawable:${Version.VectorDrawable}"
    }

    object JetPack {
        //paging3
        const val PagingRuntime = "androidx.paging:paging-runtime:${Version.Paging}"
        const val pagingCommon = "androidx.paging:paging-common:${Version.Paging}"

        //room
        const val RoomRuntime = "androidx.room:room-runtime:${Version.Room}"
        const val RoomCompilerKapt = "androidx.room:room-compiler:${Version.Room}"
        const val RoomKtx = "androidx.room:room-ktx:${Version.Room}"

        //viewpager2
        const val Viewpager = "androidx.viewpager2:viewpager2:${Version.Viewpager}"

        //navigation
        const val NavigationFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Version.Navigation}"
        const val NavigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Version.Navigation}"
    }

    object Kotlin {
        //kotlin 协程
        const val KotlinxCoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
        const val KotlinxCoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"

        //koin---依赖注入
        const val KotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Koin}"
        const val KoinCore = "org.koin:koin-core:${Version.Koin}"
        const val KoinCoreExt = "org.koin:koin-core-ext:${Version.Koin}"
        const val KoinAndroidxScope = "org.koin:koin-androidx-scope:${Version.Koin}"
        const val KoinAndroidxViewModel = "org.koin:koin-androidx-viewmodel:${Version.Koin}"
        const val KoinAndroidxFragment = "org.koin:koin-androidx-fragment:${Version.Koin}"
        const val KoinAndroidxExt = "org.koin:koin-androidx-ext:${Version.Koin}"
    }

    object GitHub {
        //gson
        const val Gson = "com.google.code.gson:gson:${Version.Gson}"

        //livedatabus
        const val LiveDataBus = "io.github.jeremyliao:live-event-bus-x:${Version.LiveDataBus}"

        //http
        const val Okhttp = "com.squareup.okhttp3:okhttp:${Version.Okhttp}"
        const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.Okhttp}"
        const val ConverterGson = "com.squareup.retrofit2:converter-gson:${Version.Retrofit}"
        const val Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"

        //log
        const val Logger = "com.orhanobut:logger:${Version.Logger}"

        //json动画
        const val Lottie = "com.airbnb.android:lottie:${Version.Lottie}"

        //loadsir
        const val LoadSir = "com.kingja.loadsir:loadsir:${Version.LoadSir}"

        //Arouter---阿里路由
        const val ArouterApi = "com.alibaba:arouter-api:${Version.ArouterApi}"
        const val ArouterCompilerKapt =
            "com.alibaba:arouter-compiler:${Version.ArouterCompilerKapt}"

        //refresh-layout
        const val RefreshLayout = "com.scwang.smart:refresh-layout-kernel:${Version.RefreshLayout}"

        //key-value组件，替代SharedPreferences
        const val MMKV = "com.tencent:mmkv:${Version.MMKV}"
    }
}