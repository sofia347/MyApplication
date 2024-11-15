package com.example.myapplication_ejmplo.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuModel(
    val id:Int,
    var title: String,
    var option: String,
    val icon: ImageVector
)
