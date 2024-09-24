package com.example.myapplication_ejmplo

import android.os.Bundle
import androidx.compose.ui.unit.sp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication_ejmplo.ui.screens.HomeScreen
import com.example.myapplication_ejmplo.ui.screens.MenuScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            CamScanner()
            //ComposeMultiScreenApp()


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
        */
            }
        }
    }

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
    fun ModifierExample() {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(text = "Hello World")
        }
    }

    //@Preview(showBackground = true)
    @Composable
    fun ModifierExample2() {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clickable(onClick = { clickAction() })
        ) {
            Text(text = "Hello World")
        }
    }

//@Preview(showBackground = true)
    @Composable
    fun ModifierExample3() {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(Color.Blue)
                .border(width = 2.dp, color = Color.Gray)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Item 1")
            Text(text = "Item 2")
            Text(text = "Item 3")
            Text(text = "Item 4")
            Text(text = "Item 5")
            Text(text = "Item 6")
        }
    }

    fun clickAction() {
        println("Column Clicked")
    }

    //@Preview(showBackground = true)
    @Composable
    fun CustomText() {
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
    fun Picture() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
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
    fun Content1() {
        Card(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(
                text = "This is a title", fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
            )
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.eslogan),
                contentDescription = "Eslogan",
                contentScale = ContentScale.Crop
            )

            Text(
                stringResource(R.string.text_card),
                textAlign = TextAlign.Justify,
                lineHeight = 18.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }

    //@Preview(showBackground = true)
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

    //@Preview(showBackground = true)
    @Composable
    fun BoxExample1() {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Image(
                painterResource(R.drawable.logoletras),
                contentDescription = "Logo y nombre",
                contentScale = ContentScale.FillBounds
            )

            Row(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
            ) {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = "Icon"
                )
                Text(text = "Text")
            }
        }
    }

    //@Preview(showBackground = true)
    @Composable
    fun BoxExapmple2() {
        Box(
            modifier = Modifier
                .background(Color.Magenta)
                .padding(5.dp)
                .size(250.dp)
        ) {
            Text(text = "TopStart", Modifier.align(Alignment.TopStart))
            Text(text = "TopEnd", Modifier.align(Alignment.TopEnd))
            Text(text = "CenterStart", Modifier.align(Alignment.CenterStart))
            Text(text = "Center", Modifier.align(Alignment.Center))
            Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
            Text(text = "BottomStart", Modifier.align(Alignment.BottomStart))
            Text(text = "BottomEnd", Modifier.align(Alignment.BottomEnd))
        }
    }

    @Composable
    fun ComposeMultiScreenApp() {
        val navController = rememberNavController()
        Surface(color = Color.White) {
            SetupNavGraph(navController = navController)
        }
    }

    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "menu") {
            composable("menu") { MenuScreen(navController) }
            composable("home") { HomeScreen(navController) }
        }

    } //Scalfull

@Preview(showBackground = true)
@Composable
fun CamScanner(){
    Column(){
        Column(modifier = Modifier.background(Color(43,43,45,255)).fillMaxWidth().offset(x = 16.dp, y = 13.dp).height(215.dp)){
            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                Box(
                    modifier = Modifier.background(Color(28, 28, 30, 255))
                        .padding(7.dp, 7.dp, 7.dp, 6.dp).size(290.dp, 17.dp)
                ) {
                    Text(text = "Search", fontSize = 15.sp, color = Color.White, modifier = Modifier)}
                Image(
                    painter = painterResource(id = R.drawable.nube),
                    contentDescription = "Icon Nube",
                    modifier = Modifier.size(25.dp).clickable {  }
                )
                Image(
                    painter = painterResource(id = R.drawable.corona),
                    contentDescription = "Icon Corona",
                    modifier = Modifier.size(25.dp).clickable {  }
                )
            }

            Row(modifier = Modifier.offset(x = 12.dp, y = 20.dp), horizontalArrangement = Arrangement.spacedBy(25.dp)){
                
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconouno),
                        contentDescription = "Icon uno",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="Smart Scan", color = Color.White)
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconodos),
                        contentDescription = "Icon dos",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="PDF Tools", color = Color.White)
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconotres),
                        contentDescription = "Icon tres",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="Import Images",
                        color = Color.White)
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconocuatro),
                        contentDescription = "Icon cuatro",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="Import Files",
                        color = Color.White)
                }
            }

            Row(modifier = Modifier.offset(x = 19.dp, y = 45.dp), horizontalArrangement = Arrangement.spacedBy(30.dp)){

                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconocinco),
                        contentDescription = "Icon cinco",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="ID Cards", color = Color.White)
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconoseis),
                        contentDescription = "Icon seis",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="Extract Text",
                        color = Color.White)
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconosiete),
                        contentDescription = "Icon siete",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="Smart Erase", color = Color.White)
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(14.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.iconocho),
                        contentDescription = "Icon ocho",
                        modifier = Modifier.size(25.dp).clickable {  }
                    )
                    Text(text ="   All   ", color = Color.White)
                }
            }
        }

        Column(modifier = Modifier
            .background(Color(44,44,46,255)).fillMaxWidth().height(510.dp).offset(x = 15.dp, y = 19.dp)){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Recents",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "View All >",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 5.dp, end = 35.dp)
                )
            }

            Column(modifier = Modifier.padding(top = 19.dp)){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                ) {
                Image(
                    modifier = Modifier
                        .size(61.dp),
                    painter = painterResource(id = R.drawable.cuadrouno),
                    contentDescription = "Cuadro uno",
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "CamScanner 09-12-2024 07.44",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(17.dp, 8.dp, 15.dp, 3.dp)
                    )
                    Text(
                        text = "2024-09-12 07:44 | ",
                        textAlign = TextAlign.Justify,
                        fontSize = 11.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(17.dp, 0.dp, 15.dp, 5.dp)
                    )
                }
                }
                Row(modifier = Modifier.padding(top = 13.dp), horizontalArrangement = Arrangement.spacedBy(14.dp)){
                    Box(
                        modifier = Modifier
                            .size(120.dp, 32.dp)
                            .background(Color(72,72,74))
                    ) {
                        Text(
                            text = "Share",
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.align(Alignment.Center).clickable {  }
                        )
                    }


                    Box(
                        modifier = Modifier
                            .size(110.dp, 32.dp)
                            .background(Color(72,72,74))
                    ) {
                        Text(
                            text = "To Word",
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.align(Alignment.Center).clickable {  }
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(100.dp, 32.dp) // Tamaño del Box
                            .background(Color(72,72,74))// Fondo gris
                    ) {
                        Text(
                            text = "View",
                            color = Color.White,
                            fontSize = 10.sp,
                            modifier = Modifier.align(Alignment.Center).clickable {  } // Centra el texto en el Box
                        )
                    }
                }

            }

            Divider(
                color = Color(55,55,57),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 12.dp) // Espaciado vertical opcional
            )

            Column(modifier = Modifier.padding(top = 0.dp)){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(61.dp),
                        painter = painterResource(id = R.drawable.cuadrodos),
                        contentDescription = "Cuadro uno",
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "CamScanner 09-12-2024 07.43",
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(17.dp, 10.dp, 15.dp, 4.dp)
                        )
                        Text(
                            text = "2024-09-12 07:43 | ",
                            textAlign = TextAlign.Justify,
                            fontSize = 11.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(17.dp, 0.dp, 15.dp, 5.dp)
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .background(Color(28, 28, 30, 255))
                .fillMaxWidth()
                .height(65.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "CamScanner keeps your files secure.",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.Center) // Alinea el texto al centro del Box
                )

                FloatingActionButton(
                    onClick = { /* Manejar clic en la cámara */ },
                    modifier = Modifier
                        .padding(16.dp).align(Alignment.TopEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.camara), // Cambia esto por tu imagen
                        contentDescription = "Camera",
                        modifier = Modifier.size(28.dp) // Ajusta el tamaño según sea necesario
                    )
                }
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(44, 44, 46)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Filled.Home,
                label = "Home",
                onClick = { /* Manejar clic en Home */ }
            )
            BottomNavItem(
                icon = Icons.Filled.DateRange,
                label = "Files",
                onClick = { /* Manejar clic en Files */ }
            )
            BottomNavItem(
                icon = Icons.Filled.Build,
                label = "Tools",
                onClick = { /* Manejar clic en Tools */ }
            )
            BottomNavItem(
                icon = Icons.Filled.Person,
                label = "Me",
                onClick = { /* Manejar clic en Me */ }
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    iconColor: Color = Color.White, // Color del ícono
    textColor: Color = Color.Gray // Color del texto
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor // Aplicar color al ícono
        )
        Text(
            text = label,
            color = textColor, // Aplicar color al texto
            fontSize = 12.sp
        )
    }
}





