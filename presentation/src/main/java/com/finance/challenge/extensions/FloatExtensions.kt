package com.finance.challenge.extensions

import java.text.NumberFormat
import java.util.*

val Float.toCurrencyValue: String
    get() {
        val formatter = NumberFormat.getCurrencyInstance(Locale.getDefault())

        return formatter.format(this)
    }