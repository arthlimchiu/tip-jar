package com.arthlimchiu.feature.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthlimchiu.core.data.PaymentsRepository
import com.arthlimchiu.core.model.Payment
import com.arthlimchiu.feature.calculator.calculatorparser.CalculatorParser
import com.arthlimchiu.feature.calculator.tipcalculator.TipCalculator
import com.arthlimchiu.utils.date.ext.toDefaultFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
internal class CalculatorViewModel @Inject constructor(
    private val paymentsRepository: PaymentsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val calculator = TipCalculator()
    private val calculatorFormatter = CalculatorParser()

    init {
        _uiState.update { state ->
            state.copy(
                totalTip = calculatorFormatter.parseToStringWithPattern(BigDecimal.ZERO),
                tipPerPerson = calculatorFormatter.parseToStringWithPattern(BigDecimal.ZERO)
            )
        }
    }

    fun onAmountChange(amount: String) {
        _uiState.update { state -> state.copy(amount = calculatorFormatter.parseToString(amount)) }
        calculateTotals()
    }

    fun onNumOfPeopleChange(numOfPeople: Int) {
        _uiState.update { state -> state.copy(numOfPeople = numOfPeople) }
        calculateTotals()
    }

    fun onTipPercentageChange(tipPercentage: String) {
        _uiState.update { state -> state.copy(tipPercentage = calculatorFormatter.parseToString(tipPercentage)) }
        calculateTotals()
    }

    private fun calculateTotals() {
        val tipPerPerson = calculator.computeTipPerPerson(
            totalAmount = calculatorFormatter.parseToBigDecimal(_uiState.value.amount),
            tipPercentage = calculatorFormatter.parseToBigDecimal(_uiState.value.tipPercentage)
        )
        val tipPerPersonFormatted = calculatorFormatter.parseToStringWithPattern(tipPerPerson)
        _uiState.update { state -> state.copy(tipPerPerson = tipPerPersonFormatted) }
        computeTotalTip(tipPerPerson)
    }

    private fun computeTotalTip(tipPerPerson: BigDecimal) {
        val totalTip = calculator.computeTotalTip(
            tipPerPerson = tipPerPerson,
            numOfPeople = _uiState.value.numOfPeople
        )
        val totalTipFormatted = calculatorFormatter.parseToStringWithPattern(totalTip)
        _uiState.update { state -> state.copy(totalTip = totalTipFormatted) }
    }

    fun onTakePhotoChecked(takePhoto: Boolean) {
        _uiState.update { state -> state.copy(takePhoto = takePhoto) }
    }

    fun onSavePaymentClick() {
        viewModelScope.launch {
            val payment = Payment(
                timeStamp = LocalDateTime.now().toDefaultFormat(),
                totalAmountInCents = calculatorFormatter.convertToCents(_uiState.value.amount),
                totalTipInCents = calculatorFormatter.convertToCents(_uiState.value.totalTip)
            )

            paymentsRepository.savePayment(payment)
        }
    }
}