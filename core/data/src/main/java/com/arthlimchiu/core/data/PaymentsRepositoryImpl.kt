package com.arthlimchiu.core.data

import com.arthlimchiu.core.common.Dispatcher
import com.arthlimchiu.core.common.TipJarDispatchers
import com.arthlimchiu.core.local.PaymentsLocalSource
import com.arthlimchiu.core.model.Payment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PaymentsRepositoryImpl @Inject constructor(
    private val localSource: PaymentsLocalSource,
    @Dispatcher(TipJarDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : PaymentsRepository {

    override suspend fun getPayments(): Flow<List<Payment>> = withContext(ioDispatcher) {
        localSource.getPayments()
    }

    override suspend fun savePayment(payment: Payment) = withContext(ioDispatcher) {
        localSource.savePayment(payment)
    }

    override suspend fun deletePayment(id: Long) = withContext(ioDispatcher) {
        localSource.deletePayment(id)
    }
}