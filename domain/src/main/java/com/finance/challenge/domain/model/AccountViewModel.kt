package com.finance.challenge.domain.model

data class AccountViewModel(
        val formattedAmount: String,
        val name: String,
        val id: Int,
        val roi: Float
)
