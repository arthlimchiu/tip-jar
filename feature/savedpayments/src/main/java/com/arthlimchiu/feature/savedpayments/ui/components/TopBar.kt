package com.arthlimchiu.feature.savedpayments.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.R
import com.arthlimchiu.core.ui.theme.TipJarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBar(onBackClick: () -> Unit) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "SAVED PAYMENTS",
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = { onBackClick() }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = null
                    )
                }
            }
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .background(TipJarTheme.colors.mercury)
                .height(1.dp)
        )
    }
}

@Preview
@Composable
internal fun TopBarPreview() {
    TipJarTheme {
        Surface {
            TopBar(onBackClick = {})
        }
    }
}