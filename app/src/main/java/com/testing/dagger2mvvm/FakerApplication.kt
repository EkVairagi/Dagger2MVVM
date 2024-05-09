package com.testing.dagger2mvvm

import android.app.Application
import com.testing.dagger2mvvm.di.ApplicationComponent
import com.testing.dagger2mvvm.di.DaggerApplicationComponent

class FakerApplication:Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent  = DaggerApplicationComponent.factory().create(this)
    }

}