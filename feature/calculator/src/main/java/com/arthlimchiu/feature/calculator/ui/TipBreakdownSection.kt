package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.components.TipJarCheckbox
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
internal fun TipBreakdownSection(
    modifier: Modifier = Modifier,
    totalTip: String = "",
    perPersonTip: String = ""
) {
    var isChecked by remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total Tip",
                style = MaterialTheme.typography.bodyLarge
            )
            Text("$10.00")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Per Person",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "$10.00",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview
@Composable
internal fun TipBreakdownSectionPreview() {
    TipJarTheme {
        Surface {
            TipBreakdownSection()
        }
    }
}