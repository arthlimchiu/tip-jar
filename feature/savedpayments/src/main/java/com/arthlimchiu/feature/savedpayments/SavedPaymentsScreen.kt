package com.arthlimchiu.feature.savedpayments

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arthlimchiu.core.model.Payment
import com.arthlimchiu.feature.savedpayments.ui.components.PaymentItem
import com.arthlimchiu.feature.savedpayments.ui.components.TopBar

@Composable
internal fun SavedPaymentsRoute(
    viewModel: SavedPaymentsViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SavedPaymentsScreen(
        payments = uiState.payments,
        onBackClick = onBackClick
    )
}

@Composable
internal fun SavedPaymentsScreen(
    payments: List<Payment>,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 16.dp)
        ) {
            repeat(20) {
                item {
                    PaymentItem(
                        date = "2021 January 21",
                        totalAmount = "$205.23",
                        totalTip = "Tip: $20.52"
                    )
                }
            }
        }
    }
}