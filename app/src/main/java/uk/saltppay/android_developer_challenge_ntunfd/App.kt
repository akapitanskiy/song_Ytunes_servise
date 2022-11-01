package uk.saltppay.android_developer_challenge_ntunfd

import android.app.Application
import uk.saltppay.android_developer_challenge_ntunfd.di.ComponentManager

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.initAppComponent(this)
    }
}