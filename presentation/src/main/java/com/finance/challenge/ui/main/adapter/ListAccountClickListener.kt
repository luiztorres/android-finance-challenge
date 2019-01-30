package com.finance.challenge.ui.main.adapter

import com.finance.challenge.domain.model.AccountViewModel

interface ListAccountClickListener {
    fun onAccountClick(account: AccountViewModel)
}