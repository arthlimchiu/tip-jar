package com.arthlimchiu.core.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payment")
data class PaymentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "time_stamp") val timeStamp: String,
    @ColumnInfo(name = "total_amt") val totalAmount: Int,
    @ColumnInfo(name = "total_tip") val totalTip: Int,
    @ColumnInfo(name = "img_path") val imgPath: String
)