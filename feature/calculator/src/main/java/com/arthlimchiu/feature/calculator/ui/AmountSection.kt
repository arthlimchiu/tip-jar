package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.modifier.innerShadow
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
internal fun AmountSection(
    modifier: Modifier = Modifier
) {
    var amount: String by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Enter amount",
            style = MaterialTheme.typography.bodyLarge
        )
        BasicTextField(
            value = amount,
            onValueChange = { amount = it },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.displaySmall.copy(textAlign = TextAlign.Center),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .border(1.dp, TipJarTheme.colors.silverBack, MaterialTheme.shapes.medium)
                        .innerShadow(offsetX = 2.dp, offsetY = 2.dp, shape = MaterialTheme.shapes.medium)
                        .padding(horizontal = 36.dp, vertical = 24.dp)
                ) {
                    Text(
                        text = "$",
                        style = MaterialTheme.typography.
                    )
                    innerTextField()
                }
            }
        )
    }
}

@Preview
@Composable
fun AmountSectionPreview() {
    AmountSection()
}