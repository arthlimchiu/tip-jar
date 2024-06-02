package com.arthlimchiu.feature.savedpayments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthlimchiu.core.data.PaymentsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SavedPaymentsViewModel @Inject constructor(
    private val paymentsRepository: PaymentsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            paymentsRepository
                .getPayments()
                .collect { payments ->
                    _uiState.update { state ->
                        state.copy(payments = payments)
                    }
                }
        }
    }
}