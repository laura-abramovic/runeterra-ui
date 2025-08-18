package com.abramoviclaura.runeterraui.ui.regions.demacia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abramoviclaura.runeterraui.ui.shape.PointedAlmondShape
import com.abramoviclaura.runeterraui.ui.theme.LocalRuneterraColors
import com.abramoviclaura.runeterraui.ui.theme.RuneterraUITheme

@Composable
fun DemacianRaptorFlight() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LocalRuneterraColors.current.grayscale.white)
    ) {
        Box(
            Modifier
                .size(height = 70.dp, width = 200.dp)
                .align(Alignment.Center)
                .dropShadow(
                    shape = PointedAlmondShape(),
                    Shadow(
                        radius = 10.dp,
                        color = Color.Red,
                        spread = 10.dp,
                        alpha = 0.5f
                    )
                )
                .background(
                    color = Color.Black,
                    shape = PointedAlmondShape()
                )
        )
    }
}

@Preview
@Composable
private fun DemacianRaptorFlightPreview() = RuneterraUITheme {
    DemacianRaptorFlight()
}
