package com.arthlimchiu.feature.savedpayments

import com.arthlimchiu.core.model.Payment

internal data class UiState(
    val payments: List<Payment> = listOf()
)