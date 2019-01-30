package com.finance.challenge.data.manager

import com.finance.challenge.data.repository.FinanceRepository
import com.finance.challenge.data.services.FinanceService
import com.finance.challenge.domain.model.DTOAccount
import io.reactivex.Observable

class FinanceManager(private val financeService: FinanceService) : FinanceRepository {

    override fun listAccounts(): Observable<List<DTOAccount>> {
        return financeService.listAccounts()
    }
}