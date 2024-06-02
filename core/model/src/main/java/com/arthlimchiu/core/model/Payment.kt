package com.arthlimchiu.core.model

data class Payment(
    val id: Long,
    val timeStamp: String,
    val totalAmount: Int,
    val totalTip: Int,
    val imgPath: String
)