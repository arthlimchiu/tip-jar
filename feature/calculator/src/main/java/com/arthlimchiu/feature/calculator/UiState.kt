package com.arthlimchiu.feature.calculator

internal data class UiState(
    val amount: String = "",
    val numOfPeople: Int = 0,
    val tipPercentage: String = "",
    val totalTip: String = "0.00",
    val tipPerPerson: String = "0.00",
    val takePhoto: Boolean = false
)