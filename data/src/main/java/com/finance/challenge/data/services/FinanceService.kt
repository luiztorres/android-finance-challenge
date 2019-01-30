package com.finance.challenge.data.services

import com.finance.challenge.domain.model.DTOAccount
import io.reactivex.Observable
import retrofit2.http.GET


interface FinanceService {
    @GET("listAccounts")
    fun listAccounts(): Observable<List<DTOAccount>>
}