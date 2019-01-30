package com.finance.challenge.application

import android.app.Application
import android.content.SharedPreferences
import com.finance.challenge.application.di.ApplicationComponent
import com.finance.challenge.application.di.ApplicationModule
import com.finance.challenge.application.di.DaggerApplicationComponent
import com.finance.challenge.data.di.ManagerModule
import com.finance.challenge.data.di.NetworkModule
import com.finance.challenge.data.di.ServicesModule
import javax.inject.Inject

/**
 * Created by LuizTorres on 26/07/18. #
 */
class MainApplication : Application() {
    private lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .servicesModule(ServicesModule())
                .managerModule(ManagerModule())
                .build()

        applicationComponent.pin(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}