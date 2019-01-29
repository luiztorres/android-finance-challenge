package com.finance.challenge.ui.main.di

import com.finance.challenge.application.di.PerView
import com.finance.challenge.ui.main.MainContract
import com.finance.challenge.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by LuizTorres on 30/07/18. #
 */
@Module
class MainModule(var view: MainContract.View) {

    @PerView
    @Provides
    fun providesMainPresenter(): MainContract.Presenter {
        val presenter = MainPresenter()
        presenter.attachView(view)
        return presenter
    }
}