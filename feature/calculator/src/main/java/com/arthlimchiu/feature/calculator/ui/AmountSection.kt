package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.components.TipJarTextField
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
internal fun AmountSection(
    amount: String,
    onAmountChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var amountTextFieldValue by remember { mutableStateOf(TextFieldValue(amount)) }

    Column(modifier = modifier) {
        Text(
            text = "Enter amount",
            style = MaterialTheme.typography.bodyLarge
        )

        TipJarTextField(
            value = amountTextFieldValue.text,
            onValueChange = { newAmount ->
                val filteredAmount = if (newAmount.count { it == '.' } > 1) {
                    val index = newAmount.lastIndexOf('.')
                    newAmount.substring(0, index) + newAmount.substring(index + 1)
                } else {
                    newAmount.filter { it.isDigit() || it == '.' }
                }
                onAmountChange(filteredAmount)
                amountTextFieldValue = TextFieldValue(filteredAmount)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            placeholder = "100.00",
            prefix = "$",
            textStyle = MaterialTheme.typography.displaySmall.copy(textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
    }
}

@Preview
@Composable
fun AmountSectionPreview() {
    TipJarTheme {
        Surface {
            AmountSection(
                amount = "",
                onAmountChange = {},
            )
        }
    }
}