package com.example.myapplication_ejmplo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Column{
        Text(text = "This is the HomeScreen")
        Button(onClick = {navController.navigate("menu")}){

        }
    }
}