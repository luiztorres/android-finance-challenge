package com.finance.challenge.data.repository

import com.finance.challenge.domain.model.DTOAccount
import io.reactivex.Observable

interface FinanceRepository {
    fun listAccounts(): Observable<List<DTOAccount>>
}