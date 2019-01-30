package com.finance.challenge.application.di

import android.content.Context
import android.content.SharedPreferences
import com.finance.challenge.application.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by LuizTorres on 30/07/18. #
 */

@Module
class ApplicationModule(private var mainApplication: MainApplication) {
    private val preference = mainApplication.packageName + "SHARED_PREFERENCE"

    @Provides
    @Singleton
    fun providesApplication(): MainApplication {
        return mainApplication
    }

    @Provides
    @Singleton
    fun providesSharedPreference(): SharedPreferences {
        return mainApplication.getSharedPreferences(preference, Context.MODE_PRIVATE)
    }
}