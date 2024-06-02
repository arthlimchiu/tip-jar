package com.arthlimchiu.core.model

data class Payment(
    val id: Long = -1,
    val timeStamp: String,
    val totalAmountInCents: Long,
    val totalTipInCents: Long,
    val imgPath: String = ""
)