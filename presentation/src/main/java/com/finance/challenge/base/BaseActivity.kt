package com.finance.challenge.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.finance.challenge.application.MainApplication
import com.finance.challenge.application.di.ApplicationComponent


/**
 * Created by LuizTorres on 30/07/18. #
 */
abstract class BaseActivity : AppCompatActivity(), MvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return (application as MainApplication).getApplicationComponent()
    }

    override fun injectDependencies() {

    }
}