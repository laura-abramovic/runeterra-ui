package com.abramoviclaura.runeterraui.ui.shape

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class AlmondShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val rect = Rect(0f, 0f, size.width, size.height)

            // Start at left center
            moveTo(0f, size.height / 2)

            // Top arc
            arcTo(rect, 180f, -180f, false)

            // Bottom arc
            arcTo(rect, 0f, -180f, false)

            close()
        }

        return Outline.Generic(path)
    }
}

class PointedAlmondShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            // Start at left middle (sharp point)
            moveTo(0f, size.height / 2)

            // Top curve to right middle (sharp point)
            quadraticBezierTo(
                size.width / 2, 0f,     // control point (top middle)
                size.width, size.height / 2  // end point (right middle)
            )

            // Bottom curve back to left middle (sharp point)
            quadraticBezierTo(
                size.width / 2, size.height, // control point (bottom middle)
                0f, size.height / 2          // end point (left middle)
            )

            close()
        }
        return Outline.Generic(path)
    }
}
