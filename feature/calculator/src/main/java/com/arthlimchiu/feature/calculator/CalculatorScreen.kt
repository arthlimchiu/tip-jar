package com.arthlimchiu.feature.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arthlimchiu.core.ui.components.TipJarButton
import com.arthlimchiu.core.ui.theme.TipJarTheme
import com.arthlimchiu.feature.calculator.ui.AmountSection
import com.arthlimchiu.feature.calculator.ui.PeopleCountSection
import com.arthlimchiu.feature.calculator.ui.TakePhotoSection
import com.arthlimchiu.feature.calculator.ui.TipBreakdownSection
import com.arthlimchiu.feature.calculator.ui.TipPercentSection
import com.arthlimchiu.feature.calculator.ui.components.CalculatorTopBar

@Composable
internal fun CalculatorRoute(
    viewModel: CalculatorViewModel = hiltViewModel(),
    onSavedPaymentsClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    CalculatorScreen(
        amount = uiState.amount,
        onAmountChange = { amount -> viewModel.onAmountChange(amount) },
        numOfPeople = uiState.numOfPeople,
        onNumOfPeopleChange = { numOfPeople -> viewModel.onNumOfPeopleChange(numOfPeople) },
        tipPercentage = uiState.tipPercentage,
        onTipPercentageChange = { tipPercentage -> viewModel.onTipPercentageChange(tipPercentage) },
        totalTip = uiState.totalTip,
        tipPerPerson = uiState.tipPerPerson,
        takePhoto = uiState.takePhoto,
        onTakePhotoChecked = { takePhoto -> viewModel.onTakePhotoChecked(takePhoto) },
        onSavedPaymentsClick = onSavedPaymentsClick
    )
}

@Composable
internal fun CalculatorScreen(
    amount: String,
    onAmountChange: (String) -> Unit,
    numOfPeople: Int,
    onNumOfPeopleChange: (Int) -> Unit,
    tipPercentage: String,
    onTipPercentageChange: (String) -> Unit,
    totalTip: String,
    tipPerPerson: String,
    takePhoto: Boolean,
    onTakePhotoChecked: (Boolean) -> Unit,
    onSavedPaymentsClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CalculatorTopBar(onSavedPaymentsClick = onSavedPaymentsClick) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            AmountSection(
                amount = amount,
                onAmountChange = onAmountChange,
                modifier = Modifier.fillMaxWidth()
            )
            PeopleCountSection(
                numOfPeople = numOfPeople,
                onNumOfPeopleChange = onNumOfPeopleChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TipPercentSection(
                tipPercentage = tipPercentage,
                onTipPercentageChange = onTipPercentageChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TipBreakdownSection(
                totalTip = totalTip,
                tipPerPerson = tipPerPerson,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TakePhotoSection(
                takePhoto = takePhoto,
                onTakePhotoChecked = onTakePhotoChecked,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 72.dp)
            )
            TipJarButton(
                text = "Save Payment",
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )
        }
    }
}

@Preview
@Composable
internal fun CalculatorScreenPreview() {
    TipJarTheme {
        Surface {
            CalculatorScreen(
                amount = "",
                onAmountChange = {},
                numOfPeople = 0,
                onNumOfPeopleChange = {},
                tipPercentage = "",
                onTipPercentageChange = {},
                totalTip = "",
                tipPerPerson = "",
                takePhoto = true,
                onTakePhotoChecked = {},
                onSavedPaymentsClick = {}
            )
        }
    }
}
