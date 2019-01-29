package com.finance.challenge.ui.main.di

import com.finance.challenge.application.di.ApplicationComponent
import com.finance.challenge.application.di.PerView
import com.finance.challenge.ui.main.MainActivity
import dagger.Component

/**
 * Created by LuizTorres on 30/07/18. #
 */
@PerView
@Component(dependencies = [ApplicationComponent::class], modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}