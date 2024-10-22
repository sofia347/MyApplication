package com.example.myapplication_ejmplo.data.model

import androidx.compose.ui.graphics.painter.Painter

data class PostModel(
    val id : Int,
    val title: String,
    val text: String,
    val image: Painter
)