package com.arthlimchiu.core.local

import com.arthlimchiu.core.local.dao.PaymentDao
import com.arthlimchiu.core.local.mapper.asEntity
import com.arthlimchiu.core.local.mapper.asExternal
import com.arthlimchiu.core.model.Payment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PaymentsLocalSourceImpl @Inject constructor(
    private val paymentDao: PaymentDao
) : PaymentsLocalSource {

    override fun getPayments(): Flow<List<Payment>> = paymentDao
        .getAll()
        .map { payments ->
            payments.map { it.asExternal() }
        }

    override fun savePayment(payment: Payment) = paymentDao.insertPayment(payment.asEntity())
}