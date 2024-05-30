package com.arthlimchiu.feature.calculator.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CalculatorTopBar(onSavedPaymentsClick: () -> Unit) {
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