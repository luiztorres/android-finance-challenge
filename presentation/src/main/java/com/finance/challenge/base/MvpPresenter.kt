package com.finance.challenge.base

import io.reactivex.Observable

/**
 * Created by LuizTorres on 30/07/18. #
 */
interface MvpPresenter<V : MvpView> {

    fun attachView(view: V?)
    fun detachView()
    fun <T : Any> execute(observable: Observable<T>?): Observable<out T>?
}