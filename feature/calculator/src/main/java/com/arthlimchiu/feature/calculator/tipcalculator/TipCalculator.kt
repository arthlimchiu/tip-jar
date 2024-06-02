package com.arthlimchiu.feature.calculator.tipcalculator

import java.math.BigDecimal

class TipCalculator {

    fun computeTotalTip(tipPerPerson: BigDecimal, numOfPeople: Int): BigDecimal {
        return try {
            tipPerPerson.multiply(numOfPeople.toBigDecimal())
        } catch (e: Exception) {
            BigDecimal.ZERO
        }
    }

    fun computeTipPerPerson(totalAmount: BigDecimal, tipPercentage: BigDecimal): BigDecimal {
        return try {
            if (tipPercentage > BigDecimal.ZERO) {
                totalAmount.multiply(tipPercentage).divide(BigDecimal(100))
            } else {
                BigDecimal.ZERO
            }
        } catch (e: Exception) {
            BigDecimal.ZERO
        }
    }
}