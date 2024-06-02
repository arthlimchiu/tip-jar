package com.arthlimchiu.core.local

import com.arthlimchiu.core.model.Payment
import kotlinx.coroutines.flow.Flow

interface PaymentsLocalSource {

    fun getPayments(): Flow<List<Payment>>

    fun savePayment(payment: Payment)
}