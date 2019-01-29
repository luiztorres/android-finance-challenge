package com.finance.challenge.base

/**
 * Created by LuizTorres on 30/07/18. #
 */
interface MvpPresenter<V : MvpView> {

    fun attachView(view: V?)
    fun detachView()
}