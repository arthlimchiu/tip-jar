package com.arthlimchiu.tipjar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arthlimchiu.core.ui.theme.TipJarTheme
import com.arthlimchiu.tipjar.navigation.TipJarNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipJarTheme {
                TipJarNavHost()
            }
        }
    }
}