package com.finance.challenge.data.di

import com.finance.challenge.data.manager.FinanceManager
import com.finance.challenge.data.repository.FinanceRepository
import com.finance.challenge.data.services.FinanceService
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
class ManagerModule {
    @Provides
    @Reusable
    fun providesFinanceManager(financeService: FinanceService): FinanceRepository {
        return FinanceManager(financeService)
    }
}