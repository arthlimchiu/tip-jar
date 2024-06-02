package com.arthlimchiu.feature.calculator.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arthlimchiu.core.ui.components.TipJarCheckbox
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
internal fun TakePhotoSection(
    takePhoto: Boolean,
    onTakePhotoChecked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    TipJarCheckbox(
        modifier = modifier,
        isChecked = takePhoto,
        onValueChange = onTakePhotoChecked,
        label = "Take photo of receipt"
    )
}

@Preview
@Composable
internal fun TakePhotoSectionPreview() {
    TipJarTheme {
        Surface {
            TakePhotoSection(
                takePhoto = true,
                onTakePhotoChecked = {}
            )
        }
    }
}