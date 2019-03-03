package com.svapp.coroutinessandbox

import android.app.Application
import com.svapp.coroutinessandbox.di.listOfModules
import org.koin.android.ext.android.startKoin

/**
 * Created by Valentyn on 03.03.2019.
 */
class CoroutinesSandboxApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOfModules)
    }
}