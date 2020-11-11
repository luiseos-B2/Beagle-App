package com.example.beagleapp

import android.app.Application
import com.example.beagleapp.beagle.BeagleSetup

class AppApplication: Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        BeagleSetup().init(instance)
    }
}