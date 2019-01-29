package com.finance.challenge.ui.main

import android.os.Bundle
import com.finance.challenge.challenge.R
import com.finance.challenge.base.BaseActivity
import com.finance.challenge.ui.main.di.DaggerMainComponent
import com.finance.challenge.ui.main.di.MainModule
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    @Inject
    lateinit var mainPresenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun injectDependencies() {
        DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }
}
