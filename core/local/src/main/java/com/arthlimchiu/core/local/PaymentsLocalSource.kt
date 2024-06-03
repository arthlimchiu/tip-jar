package com.arthlimchiu.core.local

import com.arthlimchiu.core.model.Payment
import kotlinx.coroutines.flow.Flow

interface PaymentsLocalSource {

    fun getPayments(): Flow<List<Payment>>

    suspend fun savePayment(payment: Payment)

    suspend fun deletePayment(id: Long)
}