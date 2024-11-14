package com.example.myapplication_ejmplo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication_ejmplo.ui.screens.Components
import com.example.myapplication_ejmplo.ui.screens.ContactoCalendario
import com.example.myapplication_ejmplo.ui.screens.HomeScreen
import com.example.myapplication_ejmplo.ui.screens.LoginScreen
import com.example.myapplication_ejmplo.ui.screens.MenuScreen
import com.example.myapplication_ejmplo.ui.screens.ActividadScreen
import com.example.myapplication_ejmplo.ui.screens.BiometricsScreen
import com.example.myapplication_ejmplo.ui.screens.CamaraScreen
import com.example.myapplication_ejmplo.ui.screens.ConectividadScreen
import com.example.myapplication_ejmplo.ui.screens.LocalizacionScreen
import SegundoPlanoScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication_ejmplo.ui.screens.Sensores

//import androidx.navigation.compose.NavHostController

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                ComposeMultiScreenApp(this)
            }
        }
    }


@Composable
fun ComposeMultiScreenApp(activity: AppCompatActivity){
    val navController = rememberNavController()
    Surface(color=Color.White){
        SetupNavGraph(navController=navController,activity) //función propia //crea el grafo recordando el navcontroller donde nos encontramos
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController,activity: AppCompatActivity){
    NavHost(navController = navController, startDestination = "login"){
        composable("menu"){MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("components"){ Components(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("activity"){ ActividadScreen(navController)}

        composable("biometrics"){ BiometricsScreen(navController = navController, activity = activity)}
        composable("camara"){
            val context = LocalContext.current
            CamaraScreen(context)}
        composable("conectividad"){ ConectividadScreen(navController)}
        composable("contacto"){ ContactoCalendario(navController) }
        composable("local"){ LocalizacionScreen(navController)}
        composable("sensores"){ Sensores(navController)}
        composable("segundo"){ SegundoPlanoScreen(navController)}
    }

}


