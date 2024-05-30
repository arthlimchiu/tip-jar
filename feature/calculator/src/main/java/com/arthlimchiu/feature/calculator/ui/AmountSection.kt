package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun AmountSection() {
    var amount: String by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Enter amount")
        TextField(
            value = amount,
            onValueChange = { amount = it },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun AmountSectionPreview() {
    AmountSection()
}