package com.finance.challenge.data.di

import com.finance.challenge.data.services.FinanceService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class ServicesModule {
    @Provides
    @Reusable
    fun providesFinanceService(retrofit: Retrofit): FinanceService {
        return retrofit.create(FinanceService::class.java)
    }
}