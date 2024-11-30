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
import com.example.myapplication_ejmplo.ui.screens.BiometricsScreen
import com.example.myapplication_ejmplo.ui.screens.CamaraScreen
import SegundoPlanoScreen
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.myapplication_ejmplo.data.model.database.AppDatabase
import com.example.myapplication_ejmplo.data.model.database.DatabaseProvider
import com.example.myapplication_ejmplo.ui.Location.HomeView
import com.example.myapplication_ejmplo.ui.Location.MapsSearchView
import com.example.myapplication_ejmplo.ui.Location.SearchViewModel
import com.example.myapplication_ejmplo.ui.NetworkAPI.NetworkMonitorScreen
import com.example.myapplication_ejmplo.ui.components.ManageServiceScreen

class MainActivity : AppCompatActivity() {
        lateinit var database: AppDatabase
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            try{
                database = DatabaseProvider.getDatabase(this)
                Log.d("DB", "Database loaded successfully")
            }catch (exception:Exception){
                Log.d("DB", "error: $exception")
            }

            val searchVM = SearchViewModel() // Instancia de SearchViewModel
            setContent {
                ComposeMultiScreenApp(this, searchVM)
            }
        }
    }


@Composable
fun ComposeMultiScreenApp(activity: AppCompatActivity, searchVM: SearchViewModel){
    val navController = rememberNavController()
    Surface(color=Color.White){
        SetupNavGraph(navController = navController, activity, searchVM)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController,activity: AppCompatActivity, searchVM: SearchViewModel){
    NavHost(navController = navController, startDestination = "login"){
        composable("menu"){MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("components"){ Components(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("biometrics"){ BiometricsScreen(navController = navController, activity = activity)}
        composable("camara"){
            val context = LocalContext.current
            CamaraScreen(context)}
        composable("conectividad") { NetworkMonitorScreen(navController = navController, activity = activity) }
        composable("contacto"){ ContactoCalendario(navController) }
        composable(
            "MapsSearchView/{lat}/{long}/{address}",
            arguments = listOf(
                navArgument("lat") { type = NavType.FloatType },
                navArgument("long") { type = NavType.FloatType },
                navArgument("address") { type = NavType.StringType }
            )
        ) {
            val lat = it.arguments?.getFloat("lat") ?: 0.0f
            val long = it.arguments?.getFloat("long") ?: 0.0f
            val address = it.arguments?.getString("address") ?: ""
            MapsSearchView(lat.toDouble(), long.toDouble(), address)
        }
        composable("local"){ HomeView(navController, searchVM) }
        composable("segundo"){ SegundoPlanoScreen(navController)}
        composable("manage-service/{serviceId}"){
            backStackEntry -> val serviceId = backStackEntry.arguments?.getString("serviceId")
            ManageServiceScreen(navController, serviceId = serviceId)
        }
    }

}


