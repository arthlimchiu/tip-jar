package com.arthlimchiu.feature.calculator.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arthlimchiu.core.ui.components.TipJarCheckbox
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
internal fun TakePhotoSection(
    modifier: Modifier = Modifier
) {
    var isChecked by remember { mutableStateOf(false) }

    TipJarCheckbox(
        modifier = modifier,
        isChecked = isChecked,
        onValueChange = { isChecked = it },
        label = "Take photo of receipt"
    )
}

@Preview
@Composable
internal fun TakePhotoSectionPreview() {
    TipJarTheme {
        Surface {
            TakePhotoSection()
        }
    }
}