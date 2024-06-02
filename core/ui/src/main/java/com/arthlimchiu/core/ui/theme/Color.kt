package com.arthlimchiu.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Primary40 = Color(0xFF000000)
val OnPrimary100 = Color(0xFFFFFFFF)
val PrimaryContainer90 = Color(0xFF262626)
val OnPrimaryContainer10 = Color(0xFFb1b1b1)
val Secondary40 = Color(0xFF5e5e5e)
val OnSecondary100 = Color(0xFFFFFFFF)
val SecondaryContainer90 = Color(0xFFe6e6e6)
val OnSecondaryContainer10 = Color(0xFF4a4a4a)
val Tertiary40 = Color(0xFF000000)
val OnTertiary100 = Color(0xFFFFFFFF)
val TertiaryContainer90 = Color(0xFF262626)
val OnTertiaryContainer10 = Color(0xFFb1b1b1)
val Surface98 = Color(0xFFf9f9f9)
val OnSurface10 = Color(0xFF1b1b1b)
val Background98 = Color(0xFFf9f9f9)
val OnBackground10 = Color(0xFF1b1b1b)

@Immutable
data class TipJarColors(
    val silverBack: Color = Color(0xFFCBCBCB),
    val porpoise: Color = Color(0xFFDADADA),
    val saffron: Color = Color(0xFFF27A0A),
    val marmalade: Color = Color(0xFFD26E11),
    val silverSpoon: Color = Color(0xFFD2D2D2),
    val coldMorning: Color = Color(0xFFE5E5E5),
    val charcoal: Color = Color(0xFF7D7D7D),
    val mercury: Color = Color(0xFFEBEBEB)
)

val LocalTipJarColors = staticCompositionLocalOf { TipJarColors() }