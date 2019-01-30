package com.finance.challenge.base

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by LuizTorres on 30/07/18. #
 */
abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {
    private var compositeDisposable = CompositeDisposable()

    var view: V? = null
        private set

    override fun attachView(view: V?) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
        compositeDisposable.dispose()
    }

    override fun <T : Any> execute(observable: Observable<T>?): Observable<out T>? {
        return observable?.doOnSubscribe {
            compositeDisposable.add(it)
        }?.doOnError {
            Log.e("EXECUTE ERROR", "error", it)
        }?.observeOn(AndroidSchedulers.mainThread())?.subscribeOn(Schedulers.io())
    }
}