package com.arthlimchiu.feature.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthlimchiu.core.data.PaymentsRepository
import com.arthlimchiu.core.model.Payment
import com.arthlimchiu.feature.calculator.tipcalculator.TipCalculator
import com.arthlimchiu.utils.bigdecimal.ext.parseBigDecimalToString
import com.arthlimchiu.utils.bigdecimal.ext.parseStringToBigDecimal
import com.arthlimchiu.utils.bigdecimal.ext.parseStringToBigDecimalString
import com.arthlimchiu.utils.currency.ext.convertToCents
import com.arthlimchiu.utils.date.ext.toDefaultFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
internal class CalculatorViewModel @Inject constructor(
    private val paymentsRepository: PaymentsRepository,
    private val calculator: TipCalculator
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun onAmountChange(amount: String) {
        _uiState.update { state -> state.copy(amount = amount.parseStringToBigDecimalString()) }
        calculateTotals()
    }

    fun onNumOfPeopleChange(numOfPeople: Int) {
        _uiState.update { state -> state.copy(numOfPeople = numOfPeople) }
        calculateTotals()
    }

    fun onTipPercentageChange(tipPercentage: String) {
        _uiState.update { state -> state.copy(tipPercentage = tipPercentage.parseStringToBigDecimalString()) }
        calculateTotals()
    }

    private fun calculateTotals() {
        val tipPerPerson = calculator.computeTipPerPerson(
            totalAmount = _uiState.value.amount.parseStringToBigDecimal(),
            tipPercentage = _uiState.value.tipPercentage.parseStringToBigDecimal()
        )
        val tipPerPersonFormatted = tipPerPerson.parseBigDecimalToString()
        _uiState.update { state -> state.copy(tipPerPerson = tipPerPersonFormatted) }
        computeTotalTip(tipPerPerson)
    }

    private fun computeTotalTip(tipPerPerson: BigDecimal) {
        val totalTip = calculator.computeTotalTip(
            tipPerPerson = tipPerPerson,
            numOfPeople = _uiState.value.numOfPeople
        )
        val totalTipFormatted = totalTip.parseBigDecimalToString()
        _uiState.update { state -> state.copy(totalTip = totalTipFormatted) }
    }

    fun onTakePhotoChecked(takePhoto: Boolean) {
        _uiState.update { state -> state.copy(takePhoto = takePhoto) }
    }

    fun savePayment(imgPath: String = "") {
        viewModelScope.launch {
            val payment = Payment(
                timeStamp = LocalDateTime.now().toDefaultFormat(),
                totalAmountInCents = _uiState.value.amount.parseStringToBigDecimal().convertToCents(),
                totalTipInCents = _uiState.value.totalTip.parseStringToBigDecimal().convertToCents(),
                imgPath = imgPath
            )

            paymentsRepository.savePayment(payment)
            onPaymentSaved()
        }
    }

    private fun onPaymentSaved() {
        _uiState.value = UiState()
    }
}