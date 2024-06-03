package com.arthlimchiu.feature.savedpayments.ui.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.arthlimchiu.core.ui.theme.TipJarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PaymentItem(
    date: String,
    totalAmount: String,
    totalTip: String,
    imgUriPath: String,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    val swipeState = rememberSwipeToDismissBoxState()

    if (swipeState.currentValue == SwipeToDismissBoxValue.EndToStart) onDelete()

    SwipeToDismissBox(
        state = swipeState,
        enableDismissFromStartToEnd = false,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.errorContainer)
                    .padding(end = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .clickable { if (imgUriPath.isNotBlank()) onClick() }
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = date,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge
                )
                Row(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = totalAmount,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = totalTip,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 24.dp),
                        color = TipJarTheme.colors.charcoal,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            AsyncImage(
                model = Uri.parse(imgUriPath),
                contentDescription = null,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .size(56.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
internal fun PaymentItemPreview() {
    TipJarTheme {
        Surface {
            PaymentItem(
                date = "2021 January 21",
                totalAmount = "$205.23",
                totalTip = "Tip: $20.52",
                imgUriPath = "",
                onClick = {},
                onDelete = {}
            )
        }
    }
}