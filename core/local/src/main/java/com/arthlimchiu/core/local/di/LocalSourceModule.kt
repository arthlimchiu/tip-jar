package com.arthlimchiu.core.local.di

import com.arthlimchiu.core.local.PaymentsLocalSource
import com.arthlimchiu.core.local.PaymentsLocalSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class LocalSourceModule {

    @Binds
    abstract fun bindPaymentsLocalSource(local: PaymentsLocalSourceImpl): PaymentsLocalSource
}