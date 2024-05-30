package com.arthlimchiu.feature.calculator.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arthlimchiu.feature.calculator.CalculatorRoute

const val CALCULATOR_ROUTE = "calculator_route"

fun NavController.navigateToCalculator() = navigate(CALCULATOR_ROUTE)

fun NavGraphBuilder.calculatorScreen() {
    composable(CALCULATOR_ROUTE) {
        CalculatorRoute()
    }
}