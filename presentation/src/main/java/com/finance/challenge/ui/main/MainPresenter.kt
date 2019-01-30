package com.finance.challenge.ui.main

import android.annotation.SuppressLint
import com.finance.challenge.base.BasePresenter
import com.finance.challenge.data.repository.FinanceRepository
import com.finance.challenge.domain.model.AccountViewModel
import com.finance.challenge.extensions.toCurrencyValue

/**
 * Created by LuizTorres on 30/07/18. #
 */
class MainPresenter(val financeManager: FinanceRepository) : BasePresenter<MainContract.View>(), MainContract.Presenter {
    init {

    }

    @SuppressLint("CheckResult")
    override fun getAccountList() {
        view?.showLoading()

        execute(financeManager.listAccounts())?.flatMapIterable {
            it
        }?.map {
            AccountViewModel(it.amount?.toCurrencyValue
                    ?: 0f.toCurrencyValue, it.name ?: "", it.id ?: 0, it.roi ?: 0f)
        }?.toList()?.toObservable()?.subscribe({
            view?.feedAccountList(it)
        }, {
            view?.showError()
        }, {
            view?.dismissLoading()
        })
    }
}