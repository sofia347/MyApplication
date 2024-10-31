package com.example.myapplication_ejmplo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BiometricaScreen(navController: NavController) {
    Column{
        Text("Biometrica")
        Button(onClick = {navController.navigate("menu")}){Text(text = "REGRESAR") }
    }
}