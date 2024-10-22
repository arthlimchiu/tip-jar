package com.arthlimchiu.tipjar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arthlimchiu.feature.calculator.navigation.CALCULATOR_ROUTE
import com.arthlimchiu.feature.calculator.navigation.calculatorScreen
import com.arthlimchiu.feature.savedpayments.navigation.navigateToSavedPayments
import com.arthlimchiu.feature.savedpayments.navigation.savedPaymentsScreen

@Composable
fun TipJarNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = CALCULATOR_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        calculatorScreen(onSavedPaymentsClick = navController::navigateToSavedPayments)
        savedPaymentsScreen(onBackClick = navController::popBackStack)
    }
}