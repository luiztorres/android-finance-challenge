package com.finance.challenge.ui.main

import com.finance.challenge.base.MvpPresenter
import com.finance.challenge.base.MvpView
import com.finance.challenge.domain.model.AccountViewModel

/**
 * Created by LuizTorres on 30/07/18. #
 */
interface MainContract {
    interface View : MvpView {
        fun feedAccountList(accountViewModels: List<AccountViewModel>)
        fun showError()
        fun dismissError()
        fun showLoading()
        fun dismissLoading()
    }

    interface Presenter : MvpPresenter<View> {
        fun getAccountList()
    }
}