package com.arthlimchiu.feature.calculator

internal data class UiState(
    val amount: String = "",
    val numOfPeople: Int = 0,
    val tipPercentage: String = "",
    val totalTip: String = "",
    val tipPerPerson: String = "",
    val takePhoto: Boolean = false
)