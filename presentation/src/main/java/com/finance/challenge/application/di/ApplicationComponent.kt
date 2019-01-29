package com.finance.challenge.application.di

import android.content.SharedPreferences
import com.finance.challenge.data.di.NetworkModule
import com.finance.challenge.application.MainApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by LuizTorres on 30/07/18. #
 */

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun getSharedPreferences(): SharedPreferences
    fun pin(mainApplication: MainApplication)
}