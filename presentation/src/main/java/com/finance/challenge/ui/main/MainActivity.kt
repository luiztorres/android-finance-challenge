package com.finance.challenge.ui.main

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.finance.challenge.base.BaseActivity
import com.finance.challenge.challenge.R
import com.finance.challenge.domain.model.AccountViewModel
import com.finance.challenge.extensions.gone
import com.finance.challenge.extensions.visible
import com.finance.challenge.ui.main.adapter.ListAccountClickListener
import com.finance.challenge.ui.main.adapter.ListAccountsAdapter
import com.finance.challenge.ui.main.di.DaggerMainComponent
import com.finance.challenge.ui.main.di.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_roi.view.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, ListAccountClickListener {
    @Inject
    lateinit var mainPresenter: MainContract.Presenter

    private val listAccountAdapter by lazy { ListAccountsAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoading()

        mainPresenter.getAccountList()

        main_account_recycler_view.setHasFixedSize(true)
        main_account_recycler_view.layoutManager = LinearLayoutManager(this)
        main_account_recycler_view.adapter = listAccountAdapter

        main_error_button.setOnClickListener {
            dismissError()
            mainPresenter.getAccountList()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detachView()
    }

    override fun feedAccountList(accountViewModels: List<AccountViewModel>) {
        listAccountAdapter.setAccountViewModelList(accountViewModels)
    }

    override fun onAccountClick(account: AccountViewModel) {
        showRoiDialog(account.roi)
    }

    override fun showError() {
        main_error_container.visible()
    }

    override fun dismissError() {
        main_error_container.gone()
    }

    override fun showLoading() {
        main_loading_container.visible()
    }

    override fun dismissLoading() {
        main_loading_container.gone()
    }

    fun showRoiDialog(roi: Float) {
        val view = layoutInflater.inflate(R.layout.dialog_roi, null, false)

        val background: ColorDrawable = if (roi > 0) {
            ColorDrawable(ContextCompat.getColor(this, R.color.green))
        } else if (roi == 0f) {
            ColorDrawable(ContextCompat.getColor(this, R.color.white))
        } else {
            ColorDrawable(ContextCompat.getColor(this, R.color.red))
        }

        view.dialog_roi_container.background = background

        view.dialog_roi_count.text = roi.toString()
        val dialog = AlertDialog.Builder(this)
                .setView(view)

        dialog.show()
    }

    override fun injectDependencies() {
        DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }
}
