package com.arthlimchiu.feature.savedpayments.ui.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
internal fun ReceiptDialog(
    date: String,
    totalAmount: String,
    totalTip: String,
    imgUriPath: String,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = Uri.parse(imgUriPath),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .height(420.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .padding(16.dp)
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
        }
    }
}

@Preview
@Composable
internal fun ReceiptDialogPreview() {
    TipJarTheme {
        Surface {
            ReceiptDialog(
                date = "2021 January 21",
                totalAmount = "$205.23",
                totalTip = "Tip: $20.52",
                imgUriPath = "",
                onDismissRequest = {}
            )
        }
    }
}