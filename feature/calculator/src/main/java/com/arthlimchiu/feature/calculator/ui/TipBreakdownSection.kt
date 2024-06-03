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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.theme.TipJarTheme
import com.arthlimchiu.feature.calculator.R

@Composable
internal fun TipBreakdownSection(
    totalTip: String,
    tipPerPerson: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.label_total_tip),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(com.arthlimchiu.core.ui.R.string.dollar_amount, totalTip),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.label_per_person),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(com.arthlimchiu.core.ui.R.string.dollar_amount, tipPerPerson),
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
            TipBreakdownSection(
                totalTip = "10.00",
                tipPerPerson = "10.00"
            )
        }
    }
}