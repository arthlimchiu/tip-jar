package com.arthlimchiu.core.data

import com.arthlimchiu.core.local.PaymentsLocalSource
import com.arthlimchiu.core.model.Payment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PaymentsRepositoryImpl @Inject constructor(
    private val localSource: PaymentsLocalSource
) : PaymentsRepository {

    override suspend fun getPayments(): Flow<List<Payment>> = withContext(Dispatchers.IO) {
        localSource.getPayments()
    }

    override suspend fun savePayment(payment: Payment) = withContext(Dispatchers.IO) {
        localSource.savePayment(payment)
    }
}