package com.arthlimchiu.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arthlimchiu.core.local.model.PaymentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {

    @Query("SELECT * FROM payment ORDER by id DESC")
    fun getAll(): Flow<List<PaymentEntity>>

    @Insert
    suspend fun insertPayment(payment: PaymentEntity)

    @Query("DELETE FROM payment WHERE id == :id")
    suspend fun deletePayment(id: Long)
}