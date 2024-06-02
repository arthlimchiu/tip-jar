package com.arthlimchiu.feature.savedpayments.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arthlimchiu.feature.savedpayments.SavedPaymentsRoute

const val SAVED_PAYMENTS_ROUTE = "saved_payments_route"

fun NavController.navigateToSavedPayments() = navigate(SAVED_PAYMENTS_ROUTE)

fun NavGraphBuilder.savedPaymentsScreen(onBackClick: () -> Unit) {
    composable(SAVED_PAYMENTS_ROUTE) {
        SavedPaymentsRoute(onBackClick = onBackClick)
    }
}