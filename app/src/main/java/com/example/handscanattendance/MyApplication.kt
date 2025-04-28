package com.example.handscanattendance

import android.app.Application
import android.content.Context


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        // Inisialisasi global bisa ditaruh di sini
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}
