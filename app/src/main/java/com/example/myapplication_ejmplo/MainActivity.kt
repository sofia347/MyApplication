package com.example.myapplication_ejmplo
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.compose.ui.unit.sp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication_ejmplo.ui.theme.MyApplication_EjmploTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.layoutId
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
import com.example.myapplication_ejmplo.ui.screens.BiometricaScreen
import com.example.myapplication_ejmplo.ui.screens.CamaraScreen
import com.example.myapplication_ejmplo.ui.screens.ConectividadScreen
import com.example.myapplication_ejmplo.ui.screens.LocalizacionScreen
import com.example.myapplication_ejmplo.ui.screens.SegundoPlanoScreen
import com.example.myapplication_ejmplo.ui.screens.Sensores

//import androidx.navigation.compose.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ComposeMultiScreenApp()

            /*
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ){
                Text(text = "Simple Text")
                //ModifierExample()
                //ModifierExample2()
                //ModifierExample3()
            }*/

            //Layouts
            /*Column {
                Text(text = "Firts Row")
                Text(text = "Second Row")
                Text(text = "Third Row")
                Row {
                    Text(text = "TEXT 1")
                    Text(text = "TEXT 2")
                    Text(text = "TEXT 3")
                    Text(text = "TEXT 4")
                }
                Box {
                    Text(text = "Label 1")
                    Text(text = "Label 2")
                }
                Greeting(name = "World!")
                Greeting(name = "World!")
            }
        */}
    }
}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication_EjmploTheme {
        Greeting("Android")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column(
        modifier = Modifier.padding(24.dp)
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text = "Hello World")
    }
}

//@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Blue)
            .border(width = 2.dp, color = Color.Gray)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
        Text(text = "Item 6")
    }
}

fun clickAction(){
    println("Column Clicked")
}

@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column {
        Text(
            stringResource(R.string.hello_wordls_text),
            color = colorResource(R.color.purple_500),
            fontSize = 28.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gardientColors = listOf(Cyan, Blue)
        Text(
            stringResource(R.string.hello_wordls_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gardientColors))
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ){
         Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.eslogan),
             contentDescription = "LOGO DE UM",
             contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text(text = "This is a title"
            , fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.eslogan),
            contentDescription = "Eslogan",
            contentScale = ContentScale.Crop)

        Text(stringResource(R.string.text_card),
            textAlign = TextAlign.Justify,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Content2() {
    Card(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp), // Ajusta el tamaño de la imagen según tu diseño
                painter = painterResource(id = R.drawable.logoletras),
                contentDescription = "Eslogan",
                contentScale = ContentScale.Inside
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth() // Ajusta para que el texto ocupe el espacio restante
            ) {
                Text(
                    text = "This is a title",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Text(
                    stringResource(R.string.text_card),
                    textAlign = TextAlign.Justify,
                    lineHeight = 15.sp,
                    maxLines = 10,
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample1(){
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Image(painterResource(R.drawable.logoletras),
            contentDescription = "Logo y nombre",
            contentScale = ContentScale.FillBounds)

        Row(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
        ){
            Icon(
                Icons.Filled.AccountBox,
                contentDescription = "Icon"
            )
            Text(text = "Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExapmple2(){
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(250.dp)
    ){
        Text(text = "TopStart", Modifier.align(Alignment.TopStart))
        Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
        Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
        Text(text = "Center", Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
        Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
        Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
}*/

@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface (color = Color.White){
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "login"){
        composable("menu"){MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("components"){ Components(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("activity"){ ActividadScreen(navController)}
        composable("biometrica"){ BiometricaScreen(navController)}
        composable("camara"){ CamaraScreen(navController)}
        composable("conectividad"){ ConectividadScreen(navController)}
        composable("contacto"){ ContactoCalendario(navController) }
        composable("local"){ LocalizacionScreen(navController)}
        composable("sensores"){ Sensores(navController)}
        composable("segundo"){ SegundoPlanoScreen(navController)}
    }

}


