package com.example.dashboard.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dashboard.R

@Composable
fun Property1Default(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredSize(size = 28.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_296),
            contentDescription = "image 296",
            modifier = Modifier
                .requiredSize(size = 28.dp)
                .rotate(degrees = -180f)
        )
    }
}