package com.arthlimchiu.feature.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.theme.TipJarTheme
import com.arthlimchiu.feature.calculator.ui.AmountSection
import com.arthlimchiu.feature.calculator.ui.PeopleCountSection
import com.arthlimchiu.feature.calculator.ui.TakePhotoSection
import com.arthlimchiu.feature.calculator.ui.TipBreakdownSection
import com.arthlimchiu.feature.calculator.ui.TipPercentSection
import com.arthlimchiu.feature.calculator.ui.components.CalculatorTopBar

@Composable
internal fun CalculatorRoute(onSavedPaymentsClick: () -> Unit) {
    CalculatorScreen(onSavedPaymentsClick = onSavedPaymentsClick)
}

@Composable
internal fun CalculatorScreen(onSavedPaymentsClick: () -> Unit) {
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
            AmountSection(modifier = Modifier.fillMaxWidth())
            PeopleCountSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TipPercentSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TipBreakdownSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TakePhotoSection()
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save payment")
            }
        }
    }
}

@Preview
@Composable
internal fun CalculatorScreenPreview() {
    TipJarTheme {
        Surface {
            CalculatorScreen(onSavedPaymentsClick = {})
        }
    }
}
