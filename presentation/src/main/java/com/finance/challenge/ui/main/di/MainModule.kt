package com.finance.challenge.ui.main.di

import com.finance.challenge.application.di.PerView
import com.finance.challenge.data.manager.FinanceManager
import com.finance.challenge.data.repository.FinanceRepository
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
    fun providesMainPresenter(financeRepository: FinanceRepository): MainContract.Presenter {
        val presenter = MainPresenter(financeRepository)
        presenter.attachView(view)
        return presenter
    }
}