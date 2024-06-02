package com.arthlimchiu.utils.bigdecimal.ext

import com.arthlimchiu.utils.bigdecimal.DEFAULT_DECIMAL_FORMAT_PATTERN
import java.math.BigDecimal
import java.text.DecimalFormat

fun BigDecimal.parseBigDecimalToString(): String {
    val decimalFormat = DecimalFormat(DEFAULT_DECIMAL_FORMAT_PATTERN)
    return decimalFormat.format(this)
}

fun String.parseStringToBigDecimalString(): String {
    if (this.isBlank()) return ""

    return when {
        this.last() == '.' -> this
        else -> this.toBigDecimal().toPlainString()
    }
}

fun String.parseStringToBigDecimal(): BigDecimal {
    return try {
        if (this.isBlank()) {
            BigDecimal.ZERO
        } else {
            this.toBigDecimal()
        }
    } catch (e: Exception) {
        BigDecimal.ZERO
    }
}