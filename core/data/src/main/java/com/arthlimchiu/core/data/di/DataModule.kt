package com.arthlimchiu.core.data.di

import com.arthlimchiu.core.data.PaymentsRepository
import com.arthlimchiu.core.data.PaymentsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindsPaymentsRepository(repository: PaymentsRepositoryImpl): PaymentsRepository
}