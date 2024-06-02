package com.arthlimchiu.core.local.mapper

import com.arthlimchiu.core.local.model.PaymentEntity
import com.arthlimchiu.core.model.Payment

fun PaymentEntity.asExternal(): Payment = Payment(
    id = id,
    timeStamp = timeStamp,
    totalAmountInCents = totalAmountInCents,
    totalTipInCents = totalTipInCents,
    imgPath = imgPath
)

fun Payment.asEntity(): PaymentEntity = PaymentEntity(
    timeStamp = timeStamp,
    totalAmountInCents = totalAmountInCents,
    totalTipInCents = totalTipInCents,
    imgPath = imgPath
)