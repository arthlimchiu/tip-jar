package com.arthlimchiu.core.local.mapper

import com.arthlimchiu.core.local.model.PaymentEntity
import com.arthlimchiu.core.model.Payment

fun PaymentEntity.asExternal(): Payment = Payment(
    id = id,
    timeStamp = timeStamp,
    totalAmount = totalAmount,
    totalTip = totalTip,
    imgPath = imgPath
)

fun Payment.asEntity(): PaymentEntity = PaymentEntity(
    id = id,
    timeStamp = timeStamp,
    totalAmount = totalAmount,
    totalTip = totalTip,
    imgPath = imgPath
)