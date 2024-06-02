package com.arthlimchiu.core.data

import com.arthlimchiu.core.model.Payment
import kotlinx.coroutines.flow.Flow

interface PaymentsRepository {

    suspend fun getPayments(): Flow<List<Payment>>

    suspend fun savePayment(payment: Payment)
}