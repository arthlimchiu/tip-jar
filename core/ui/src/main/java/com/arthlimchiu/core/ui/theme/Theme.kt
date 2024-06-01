package com.arthlimchiu.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorScheme = lightColorScheme(
    primary = Primary40,
    onPrimary = OnPrimary100,
    primaryContainer = PrimaryContainer90,
    onPrimaryContainer = OnPrimaryContainer10,
    secondary = Secondary40,
    onSecondary = OnSecondary100,
    secondaryContainer = SecondaryContainer90,
    onSecondaryContainer = OnSecondaryContainer10,
    tertiary = Tertiary40,
    onTertiary = OnTertiary100,
    tertiaryContainer = TertiaryContainer90,
    onTertiaryContainer = OnTertiaryContainer10,
    background = Background98,
    onBackground = OnBackground10,
    surface = Surface98,
    onSurface = OnSurface10
)

private val tipJarColors = TipJarColors()

@Composable
fun TipJarTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTipJarColors provides tipJarColors
    ) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = Typography,
            content = content
        )
    }
}

object TipJarTheme {
    val colors: TipJarColors
        @Composable
        get() = LocalTipJarColors.current
}