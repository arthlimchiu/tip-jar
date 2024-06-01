package com.arthlimchiu.feature.calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
internal fun PeopleCountSection(
    modifier: Modifier = Modifier
) {
    var count by remember { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        Text("How many people?")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { count++ }) {
                Text("+")
            }
            Text(count.toString())
            Button(onClick = { count-- }) {
                Text("-")
            }
        }
    }
}