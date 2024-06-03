package com.arthlimchiu.feature.savedpayments

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arthlimchiu.core.model.Payment
import com.arthlimchiu.feature.savedpayments.ui.components.PaymentItem
import com.arthlimchiu.feature.savedpayments.ui.components.ReceiptDialog
import com.arthlimchiu.feature.savedpayments.ui.components.TopBar
import com.arthlimchiu.utils.bigdecimal.ext.parseBigDecimalToString
import com.arthlimchiu.utils.currency.ext.parseCentsToBigDecimal
import com.arthlimchiu.utils.date.ext.formatDateString

@Composable
internal fun SavedPaymentsRoute(
    viewModel: SavedPaymentsViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SavedPaymentsScreen(
        payments = uiState.payments,
        onBackClick = onBackClick,
        onDeletePayment = { paymentId -> viewModel.deletePayment(paymentId) }
    )
}

@Composable
internal fun SavedPaymentsScreen(
    payments: List<Payment>,
    onBackClick: () -> Unit,
    onDeletePayment: (Long) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var paymentClicked by remember { mutableStateOf<Payment?>(null) }

    Scaffold(
        topBar = {
            TopBar(onBackClick = onBackClick)
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(payments, key = { payment -> payment.id }) { payment ->
                PaymentItem(
                    date = payment.timeStamp.formatDateString(),
                    totalAmount = "$${payment.totalAmountInCents.parseCentsToBigDecimal().parseBigDecimalToString()}",
                    totalTip = "Tip: $${payment.totalTipInCents.parseCentsToBigDecimal().parseBigDecimalToString()}",
                    imgUriPath = payment.imgPath,
                    onClick = {
                        paymentClicked = payment
                        showDialog = true
                    },
                    onDelete = { onDeletePayment(payment.id) }
                )
            }
        }

        if (showDialog) {
            paymentClicked?.let { payment ->
                ReceiptDialog(
                    date = payment.timeStamp.formatDateString(),
                    totalAmount = "$${payment.totalAmountInCents.parseCentsToBigDecimal().parseBigDecimalToString()}",
                    totalTip = "Tip: $${payment.totalTipInCents.parseCentsToBigDecimal().parseBigDecimalToString()}",
                    imgUriPath = payment.imgPath,
                    onDismissRequest = { showDialog = false }
                )
            }
        }
    }
}