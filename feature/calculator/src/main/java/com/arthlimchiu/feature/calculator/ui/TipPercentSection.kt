package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun TipPercentSection() {
    var percent by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text("% TIP")
        TextField(
            value = percent,
            onValueChange = { percent = it },
            modifier = Modifier.fillMaxWidth()
        )
    }
}