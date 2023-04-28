package com.teddy_park.team_match

import android.app.Application
import com.teddy_park.team_match.util.PrefManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        PrefManager.init(applicationContext)
    }
}