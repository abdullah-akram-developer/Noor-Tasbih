package com.trihashstudio.noortasbih.ui.theme

import com.trihashstudio.noortasbih.R
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val ArabicFont = FontFamily(
    Font(R.font.arabic_font)
)
val LatoFont = FontFamily(
    Font(R.font.lato_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = ArabicFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        color = Color.White,
        lineHeight = 34.sp,
        letterSpacing = 1.5.sp
    ),
    displayLarge =  TextStyle(
        fontFamily = ArabicFont,
        fontWeight = FontWeight.W500,
        fontSize = 55.sp,
        lineHeight = 64.sp,
        color = Color.White
    ),
    displayMedium = TextStyle(
        fontFamily = ArabicFont,
        fontWeight = FontWeight.W500,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        color = Color.White
    ),
    displaySmall = TextStyle(
        fontFamily = ArabicFont,
        fontWeight = FontWeight.W500,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        color = Color.White
    ),
    headlineLarge = TextStyle(
        fontFamily = ArabicFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        color = Color.White,
        lineHeight = 40.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = LatoFont,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        color = Color.White,
        lineHeight = 36.sp,
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

