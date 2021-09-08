package com.flexcode.musicui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Latest(
    val title:String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
