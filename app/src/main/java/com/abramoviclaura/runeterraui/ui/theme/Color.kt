package com.abramoviclaura.runeterraui.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val White = Color(0xFFFFFFFF)
val Gray10 = Color(0xFFE6E6E6)
val Gray20 = Color(0xFFCCCCCC)
val Gray30 = Color(0xFFB3B3B3)
val Gray40 = Color(0xFF999999)
val Gray50 = Color(0xFF808080)
val Gray60 = Color(0xFF666666)
val Gray70 = Color(0xFF4C4C4C)
val Gray80 = Color(0xFF333333)
val Gray90 = Color(0xFF191919)
val Black = Color(0xFF000000)

val LightBlue = Color(0xFF3BA2F9)
val DarkBlue = Color(0xFF202F4C)
val Gold = Color(0xFFA58344)

val grayscalePalette = Grayscale(
    white = White,
    gray10 = Gray10,
    gray20 = Gray20,
    gray30 = Gray30,
    gray40 = Gray40,
    gray50 = Gray50,
    gray60 = Gray60,
    gray70 = Gray70,
    gray80 = Gray80,
    gray90 = Gray90,
    black = Black
)

val demacianPalette = DemacianColors(
    gold = Gold,
    lightBlue = LightBlue,
    darkBlue = DarkBlue
)

@Immutable
data class Grayscale(
    val white: Color = Color.Unspecified,
    val gray10: Color = Color.Unspecified,
    val gray20: Color = Color.Unspecified,
    val gray30: Color = Color.Unspecified,
    val gray40: Color = Color.Unspecified,
    val gray50: Color = Color.Unspecified,
    val gray60: Color = Color.Unspecified,
    val gray70: Color = Color.Unspecified,
    val gray80: Color = Color.Unspecified,
    val gray90: Color = Color.Unspecified,
    val black: Color = Color.Unspecified,
)

@Immutable
data class DemacianColors(
    val gold: Color = Color.Unspecified,
    val lightBlue: Color = Color.Unspecified,
    val darkBlue: Color = Color.Unspecified,
)

@Immutable
data class RuneterraColors(
    val grayscale: Grayscale,
    val demacian: DemacianColors,
)

val LocalRuneterraColors = staticCompositionLocalOf {
    RuneterraColors(
        grayscale = Grayscale(),
        demacian = DemacianColors()
    )
}
