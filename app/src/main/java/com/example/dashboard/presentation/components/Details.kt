package com.example.dashboard.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Details(
    icon: Painter,
    text1: String,
    text2: String
) {
    Box(
        modifier = Modifier
            .requiredSize(size = 120.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 12.dp,
                    y = 12.dp
                )
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(size = 32.dp)
                    .clip(shape = RoundedCornerShape(100.dp))
                    .background(color = Color(0xff5c33cf).copy(alpha = 0.12f))
            ) {
                Image(
                    painter = icon,
                    contentDescription = "Software",
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(
                            x = 6.dp,
                            y = 6.dp
                        )
                        .requiredSize(size = 20.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = text1,
                        color = Color.Black,
                        lineHeight = 1.5.em,
                        style = TextStyle(
                            fontSize = 16.sp
                        ),
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                }
                Text(
                    text = text2,
                    color = Color(0xff999ca0),
                    lineHeight = 1.43.em,
                    style = TextStyle(
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        }
    }
}
