package com.arthlimchiu.feature.calculator.calculatorparser

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class CalculatorParser {

    fun parseToStringWithPattern(value: BigDecimal, pattern: String = "#0.00"): String {
        val decimalFormat = DecimalFormat(pattern)
        return decimalFormat.format(value)
    }

    fun parseToString(value: String): String {
        if (value.isBlank()) return ""

        return when {
            value.last() == '.' -> value
            else -> value.toBigDecimal().toPlainString()
        }
    }

    fun parseToBigDecimal(value: String): BigDecimal {
        return try {
            if (value.isBlank()) {
                BigDecimal.ZERO
            } else {
                value.toBigDecimal()
            }
        } catch (e: Exception) {
            BigDecimal.ZERO
        }
    }

    fun convertToCents(value: String): Long {
        val valueInBigDecimal = parseToBigDecimal(value)
        return convertToCents(valueInBigDecimal)
    }

    fun convertToCents(value: BigDecimal): Long {
        return value
            .setScale(2, RoundingMode.HALF_EVEN)
            .multiply(BigDecimal(100))
            .toLong()
    }
}