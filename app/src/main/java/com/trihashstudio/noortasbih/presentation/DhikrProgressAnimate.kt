package com.trihashstudio.noortasbih.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DhikrProgressAnimate(
    progress: Int,
    max: Int = 33
) {
    val targetProgress = progress.toFloat() / max.toFloat()

    // Animate the fraction
    val animatedProgress by animateFloatAsState(
        targetValue = targetProgress,
        animationSpec = androidx.compose.animation.core.tween(
            durationMillis = 800 // animation duration
        ),
        label = ""
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(150.dp) // circle size
    ) {
        // Background circle
        CircularProgressIndicator(
            progress = 1f,
            color = Color.LightGray.copy(alpha = 0.3f),
            strokeWidth = 12.dp,
            modifier = Modifier.fillMaxSize()
        )

        // Animated progress arc
        CircularProgressIndicator(
            progress = animatedProgress,
            color = Color(0xFFCF9857), // golden orange
            strokeWidth = 12.dp,
            modifier = Modifier.fillMaxSize()
        )

        // Text in center
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$progress", style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = "/$max", style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}
