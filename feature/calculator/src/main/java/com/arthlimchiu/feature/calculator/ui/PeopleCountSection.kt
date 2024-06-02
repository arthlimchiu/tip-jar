package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arthlimchiu.core.ui.theme.TipJarTheme

@Composable
internal fun PeopleCountSection(
    numOfPeople: Int,
    onNumOfPeopleChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "How many people?",
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val buttonBorderColor = TipJarTheme.colors.silverSpoon

            Button(
                onClick = { onNumOfPeopleChange(numOfPeople + 1) },
                modifier = Modifier
                    .widthIn(min = 72.dp)
                    .drawBehind {
                        drawCircle(
                            color = buttonBorderColor,
                            style = Stroke(width = 3f)
                        )
                    },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    text = "+",
                    color = TipJarTheme.colors.saffron,
                    style = MaterialTheme.typography.displaySmall
                )
            }
            Text(
                text = numOfPeople.toString(),
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall,
            )
            Button(
                onClick = { onNumOfPeopleChange(numOfPeople - 1) },
                modifier = Modifier
                    .widthIn(min = 72.dp)
                    .drawBehind {
                        drawCircle(
                            color = buttonBorderColor,
                            style = Stroke(width = 3f)
                        )
                    },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    text = "-",
                    color = TipJarTheme.colors.saffron,
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }
}

@Preview
@Composable
internal fun PeopleCountSectionPreview() {
    TipJarTheme {
        Surface {
            PeopleCountSection(
                numOfPeople = 0,
                onNumOfPeopleChange = {}
            )
        }
    }
}