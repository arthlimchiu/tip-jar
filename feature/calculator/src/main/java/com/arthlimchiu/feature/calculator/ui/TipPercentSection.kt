package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
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

@Composable
internal fun TipPercentSection(
    tipPercentage: String,
    onTipPercentageChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var tipPercentageTextFieldValue by remember { mutableStateOf(TextFieldValue(tipPercentage)) }

    Column(modifier = modifier) {
        Text(
            text = "% TIP",
            style = MaterialTheme.typography.bodyLarge
        )

        TipJarTextField(
            value = tipPercentageTextFieldValue.text,
            onValueChange = { newValue ->
                val filteredValue = if (newValue.count { it == '.' } > 1) {
                    val index = newValue.lastIndexOf('.')
                    newValue.substring(0, index) + newValue.substring(index + 1)
                } else {
                    newValue.filter { it.isDigit() || it == '.' }
                }
                onTipPercentageChange(filteredValue)
                tipPercentageTextFieldValue = TextFieldValue(filteredValue)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            placeholder = "10",
            suffix = "%",
            textStyle = MaterialTheme.typography.displaySmall.copy(textAlign = TextAlign.Center),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
    }
}

@Preview
@Composable
internal fun TipPercentSectionPreview() {

}