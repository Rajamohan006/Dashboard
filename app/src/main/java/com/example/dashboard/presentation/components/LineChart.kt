package com.example.dashboard.presentation.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun LineChart(
    data: List<Pair<String, Int>> = emptyList(),
    modifier: Modifier = Modifier
) {
    val spacing = 38.dp
    val graphColor = Color.Cyan
    val transparentGraphColor = remember { graphColor.copy(alpha = 0.5f) }
    val density = LocalDensity.current

    // Define fixed y-axis values
    val yAxisValues = listOf(0, 25, 50, 75, 100)
    val maxYValue = yAxisValues.maxOrNull() ?: 100
    val minYValue = yAxisValues.minOrNull() ?: 0

    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Canvas(modifier = modifier) {
        val spacePerMonth = (size.width - spacing.toPx()) / (data.size - 1)

        // Draw x-axis labels
        data.forEachIndexed { i, (month, _) ->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    month,
                    spacing.toPx() + i * spacePerMonth,
                    size.height,
                    textPaint
                )
            }
        }

        // Draw y-axis labels
        val yAxisSpacing = (size.height - 2 * spacing.toPx()) / (yAxisValues.size - 1)
        yAxisValues.forEachIndexed { i, value ->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    value.toString(),
                    30f,
                    size.height - spacing.toPx() - i * yAxisSpacing,
                    textPaint
                )
            }
        }

        // Define the path for the line chart
        val strokePath = Path().apply {
            val height = size.height
            data.forEachIndexed { i, info ->
                val ratio = (info.second - minYValue).toFloat() / (maxYValue - minYValue).toFloat()
                val x1 = spacing.toPx() + i * spacePerMonth
                val y1 = height - spacing.toPx() - (ratio * (height - 2 * spacing.toPx()))

                if (i == 0) {
                    moveTo(x1, y1)
                } else {
                    lineTo(x1, y1)
                }
            }
        }

        // Draw the line chart path
        drawPath(
            path = strokePath,
            color = graphColor,
            style = Stroke(
                width = 2.dp.toPx(),
                cap = StrokeCap.Round
            )
        )

        // Define the fill path for the area under the curve
        val fillPath = Path().apply {
            addPath(strokePath)
            lineTo(size.width - spacing.toPx(), size.height - spacing.toPx())
            lineTo(spacing.toPx(), size.height - spacing.toPx())
            close()
        }

        // Draw the area under the curve
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    transparentGraphColor,
                    Color.Transparent
                ),
                endY = size.height - spacing.toPx()
            )
        )
    }
}
