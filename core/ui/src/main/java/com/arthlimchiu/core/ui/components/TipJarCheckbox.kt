package com.arthlimchiu.core.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.R
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
fun TipJarCheckbox(
    onValueChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    label: String = "",
    checkedColor: Color = TipJarTheme.colors.saffron,
    uncheckedColor: Color = TipJarTheme.colors.coldMorning
) {
    val checkboxColor: Color by animateColorAsState(
        if (isChecked) checkedColor else uncheckedColor,
        label = "Checkbox Animation"
    )

    Row(
        modifier = modifier
            .toggleable(
                value = isChecked,
                onValueChange = onValueChange,
                role = Role.Checkbox,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
    ) {
        Box(modifier = Modifier.border(1.dp, checkboxColor, MaterialTheme.shapes.small)) {
            val checkboxImageRes = if (isChecked) R.drawable.ic_checked else R.drawable.ic_unchecked
            Image(
                painter = painterResource(checkboxImageRes),
                contentDescription = "",
                modifier = Modifier.padding(10.dp)
            )
        }
        if (label.isNotBlank()) {
            Text(
                text = label,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
internal fun TipJarCheckboxPreview() {
    TipJarTheme {
        Surface {
            TipJarCheckbox(
                onValueChange = {},
                label = "Take photo of receipt"
            )
        }
    }
}