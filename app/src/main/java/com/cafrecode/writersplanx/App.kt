package com.cafrecode.writersplanx

import android.app.Activity
import android.app.Application
import android.app.Service
import com.cafrecode.writersplanx.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    var dispatchingServiceInjector: DispatchingAndroidInjector<Service>? = null

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun serviceInjector(): AndroidInjector<Service?>? {
        return dispatchingServiceInjector
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}