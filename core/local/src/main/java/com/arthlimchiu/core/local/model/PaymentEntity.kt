package com.arthlimchiu.core.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payment")
data class PaymentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "time_stamp") val timeStamp: String,
    @ColumnInfo(name = "total_amt_in_cents") val totalAmountInCents: Long,
    @ColumnInfo(name = "total_tip_in_cents") val totalTipInCents: Long,
    @ColumnInfo(name = "img_path") val imgPath: String
)