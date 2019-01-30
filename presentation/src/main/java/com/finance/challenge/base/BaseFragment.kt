package com.finance.challenge.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.finance.challenge.application.di.ApplicationComponent

/**
 * Created by LuizTorres on 01/08/18. #
 */
abstract class BaseFragment : Fragment(), MvpView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }

    private fun getBaseActivity(): BaseActivity? {
        return activity as? BaseActivity
    }

    fun getApplicationComponent(): ApplicationComponent? {
        return getBaseActivity()?.getApplicationComponent()
    }

    abstract override fun injectDependencies()
}