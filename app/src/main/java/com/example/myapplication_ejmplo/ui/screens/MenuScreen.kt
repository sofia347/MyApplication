package com.example.myapplication_ejmplo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun MenuScreen(navController: NavController){
    Column{
        Text(text = "This is the Menu Screen")
        Button(onClick = {navController.navigate("home")}){Text(text = "HOME") }
        Button(onClick = {navController.navigate("components")}){Text(text = "Components") }
        Button(onClick = {navController.navigate("segundo")}){Text(text = "Programacion de tareas en 2do plano") }
        Button(onClick = {navController.navigate("local")}){Text(text = "Servicios de localizacion") }
        Button(onClick = {navController.navigate("contacto")}){Text(text = "Accesso a contactos y calendario") }
        Button(onClick = {navController.navigate("camara")}){Text(text = "Acceso a camara y manejo de archivos") }
        Button(onClick = {navController.navigate("conectividad")}){Text(text = "Conectiidad WiFi y datos") }
    }

}