package com.abramoviclaura.runeterraui.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun RuneterraUITheme(content: @Composable () -> Unit) {
    val runeterraColors = RuneterraColors(
        grayscale = grayscalePalette,
        demacian = demacianPalette
    )

    CompositionLocalProvider(
        LocalRuneterraColors provides runeterraColors,
        content = content
    )
}
