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
    }

}