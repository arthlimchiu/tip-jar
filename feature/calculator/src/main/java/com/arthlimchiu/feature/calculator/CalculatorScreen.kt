package com.arthlimchiu.feature.calculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.R

@Composable
internal fun CalculatorRoute(onSavedPaymentsClick: () -> Unit) {
    CalculatorScreen(onSavedPaymentsClick = onSavedPaymentsClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CalculatorScreen(onSavedPaymentsClick: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Image(
                        modifier = Modifier.padding(top = 8.dp),
                        painter = painterResource(R.drawable.tipjar_logo),
                        contentDescription = null
                    )
                },
                actions = {
                    IconButton(onClick = { onSavedPaymentsClick() }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(R.drawable.ic_history),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {

        }
    }
}