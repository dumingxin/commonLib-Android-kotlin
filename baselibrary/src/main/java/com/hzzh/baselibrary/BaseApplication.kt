package com.hzzh.baselibrary

import android.app.Application

/**
 * Created by dmx on 2017/8/11.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: BaseApplication
    }
}
