package com.finance.challenge.ui.main

import com.finance.challenge.base.MvpPresenter
import com.finance.challenge.base.MvpView

/**
 * Created by LuizTorres on 30/07/18. #
 */
interface MainContract {
    interface View : MvpView {

    }

    interface Presenter : MvpPresenter<View> {

    }
}