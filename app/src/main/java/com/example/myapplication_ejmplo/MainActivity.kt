package com.example.myapplication_ejmplo
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication_ejmplo.ui.Biometrics.BiometricPromptManager
import com.example.myapplication_ejmplo.ui.screens.Sensores

//import androidx.navigation.compose.NavHostController

class MainActivity : AppCompatActivity() {
    private  val promptManager  by lazy{
        BiometricPromptManager(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BiometricsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // ------------------- MAIN CONTENT -------------------
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        ComposeMultiScreenApp(promptManager)


                    }
                }
            }
        }
    }
}


@Composable
fun ComposeMultiScreenApp(promptManager:BiometricPromptManager){
    val navController = rememberNavController()
    Surface (color = Color.White){
        SetupNavGraph(navController = navController, promptManage)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController, activity: AppCompatActivity){
    NavHost(navController = navController, startDestination = "login"){
        composable("menu"){MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("components"){ Components(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("activity"){ ActividadScreen(navController)}
        composable("biometrica"){ BiometricsScreen(activity)}
        composable("camara"){ CamaraScreen(navController)}
        composable("conectividad"){ ConectividadScreen(navController)}
        composable("contacto"){ ContactoCalendario(navController) }
        composable("local"){ LocalizacionScreen(navController)}
        composable("sensores"){ Sensores(navController)}
        composable("segundo"){ SegundoPlanoScreen(navController)}
    }

}


