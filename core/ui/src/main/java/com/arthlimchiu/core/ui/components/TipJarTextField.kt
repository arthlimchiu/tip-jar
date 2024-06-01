package com.arthlimchiu.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.modifier.innerShadow
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
fun TipJarTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    prefix: String = "",
    suffix: String = "",
    textStyle: TextStyle = TextStyle.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1
) {
    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        textStyle = textStyle,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        keyboardOptions = keyboardOptions,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .border(1.dp, TipJarTheme.colors.silverBack, MaterialTheme.shapes.medium)
                    .innerShadow(offsetX = 2.dp, offsetY = 2.dp, shape = MaterialTheme.shapes.medium)
                    .padding(horizontal = 36.dp, vertical = 24.dp)
            ) {
                if (prefix.isNotBlank()) {
                    Text(
                        text = prefix,
                        modifier = Modifier.align(Alignment.CenterStart),
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                if (value.isBlank()) {
                    Text(
                        text = placeholder,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        color = TipJarTheme.colors.porpoise,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.displaySmall
                    )
                }

                Box(
                    modifier = Modifier.padding(horizontal = 36.dp)
                ) {
                    innerTextField()
                }

                if (suffix.isNotBlank()) {
                    Text(
                        text = suffix,
                        modifier = Modifier.align(Alignment.CenterEnd),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    )
}

@Composable
@Preview
internal fun TipJarTextFieldPreview() {
    TipJarTheme {
        Surface {
            TipJarTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                placeholder = "100.00",
                prefix = "$",
                suffix = "%",
                singleLine = true,
                textStyle = MaterialTheme.typography.displaySmall.copy(textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}