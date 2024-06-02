package com.arthlimchiu.utils.currency.ext

import com.arthlimchiu.utils.currency.DEFAULT_DECIMAL_PLACES
import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.convertToCents(): Long {
    return this
        .setScale(DEFAULT_DECIMAL_PLACES, RoundingMode.HALF_EVEN)
        .multiply(BigDecimal(100))
        .toLong()
}

fun Long.parseCentsToString(): String {
    return this.toBigDecimal().divide(BigDecimal(100)).toPlainString()
}