package com.arthlimchiu.core.local.di

import android.content.Context
import com.arthlimchiu.core.local.TipDatabase
import com.arthlimchiu.core.local.dao.PaymentDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun providesTipDatabase(@ApplicationContext context: Context): TipDatabase {
        return TipDatabase.getInstance(context)
    }

    @Provides
    fun providesPaymentDao(database: TipDatabase): PaymentDao = database.paymentDao()
}