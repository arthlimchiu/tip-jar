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

fun Long.parseCentsToBigDecimal(): BigDecimal {
    return this
        .toBigDecimal()
        .setScale(DEFAULT_DECIMAL_PLACES, RoundingMode.HALF_EVEN)
        .divide(BigDecimal(100))
}