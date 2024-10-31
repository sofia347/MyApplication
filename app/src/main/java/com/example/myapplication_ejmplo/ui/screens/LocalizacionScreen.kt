package com.example.myapplication_ejmplo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun LocalizacionScreen(navController: NavController) {
    Column{
        Text("Localizacion")
        Button(onClick = {navController.navigate("menu")}){Text(text = "REGRESAR") }
    }
}