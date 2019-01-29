package com.finance.challenge.base

/**
 * Created by LuizTorres on 30/07/18. #
 */
abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {
    var view: V? = null
        private set

    override fun attachView(view: V?) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}