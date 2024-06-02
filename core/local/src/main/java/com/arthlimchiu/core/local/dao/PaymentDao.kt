package com.arthlimchiu.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arthlimchiu.core.local.model.PaymentEntity

@Dao
interface PaymentDao {

    @Query("SELECT * FROM payment")
    fun getAll(): List<PaymentEntity>

    @Insert
    fun insertPayment(payment: PaymentEntity)
}