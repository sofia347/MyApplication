package com.example.myapplication_ejmplo.ui.screens

import android.widget.TimePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun ComponentsScreen(navController: NavController) {
    var component by remember { mutableStateOf("") }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Text("Menu", modifier = Modifier.padding(16.dp))
            HorizontalDivider()
            //Content 1
            NavigationDrawerItem(
                label = { Text(text = "Content 1")},
                selected = false,
                onClick = {
                    component = "Content1"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 2
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Content 2")},
                selected = false,
                onClick = {
                    component = "Content2"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 3
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Button")},
                selected = false,
                onClick = {
                    component = "Button"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 4
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "FloatingButtons")},
                selected = false,
                onClick = {
                    component = "FloatingButtons"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 5
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Chips")},
                selected = false,
                onClick = {
                    component = "Chips"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 6
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "InputExample")},
                selected = false,
                onClick = {
                    component = "InputExample"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 7
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Progress")},
                selected = false,
                onClick = {
                    component = "Progress"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 8
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Sliders")},
                selected = false,
                onClick = {
                    component = "Sliders"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 9
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Switches")},
                selected = false,
                onClick = {
                    component = "Switches"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 10
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Badges")},
                selected = false,
                onClick = {
                    component = "Badges"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 11
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "TimePickers")},
                selected = false,
                onClick = {
                    component = "TimePickers"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 12
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "DatePickers")},
                selected = false,
                onClick = {
                    component = "DatePickers"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 13
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "SnackBars")},
                selected = false,
                onClick = {
                    component = "SnackBars"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 14
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "AlertDialogs")},
                selected = false,
                onClick = {
                    component = "AlertDialogs"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
            //Content 15
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Bars")},
                selected = false,
                onClick = {
                    component = "Bars"
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )

        }
    }) {
        Column {
            when(component){
                "Content1" ->
                    Conent1()
                "Content2" ->
                    Content2()
                "Button" ->
                    Button()
                "FloatingButtons" ->
                    FloatingButtons()
                "Chips" ->
                    Chips()
                "InputExample" ->
                    InputExample("Dimiss", {})
                "Progress" ->
                    Progress()
                "Sliders" ->
                    Sliders()
                "Switches" ->
                    Switches()
                "Badges" ->
                    Badges()
                "TimePickers" ->
                    TimePickers(onConfirm = { /*TODO*/ }) {
                    }
                "DatePickers" ->
                    DatePickers()
                "SnackBars" ->
                    SnackBars()
                "AlertDialogs" ->
                    AlertDialogs()
                "Bars" ->
                    Bars()
            }
        }
    }

}

@Composable
fun Conent1(){
    Text(text = "Content 1")
}

@Composable
fun Content2(){
    Text(text = "Content 2")
}

@Composable
fun Button() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ){
        androidx.compose.material3.Button(onClick = { /*TODO*/ }) {
            Text(text = "Filled")
        }
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Tonal")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "OutLine")
        }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Elevated")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Text")
        }
        
    }
}

@Composable
fun FloatingButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Search, "")
        }
        SmallFloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Search, "")
        }
        LargeFloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Search, "")
        }
        ExtendedFloatingActionButton(onClick = { /*TODO*/ },
            icon = { Icon(Icons.Filled.Search, "") },
            text = { Text(text = "Extended FAB") })
    }
}

@Composable
fun Chips() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        AssistChip(onClick = { /*TODO*/ }, label = {Text(text = "Assist Chip")},
            leadingIcon = {
                Icon(Icons.Filled.AccountBox, "", Modifier.size(AssistChipDefaults.IconSize))
            })

        var selected by remember { mutableStateOf(false)}
        FilterChip(
            selected = selected,
            onClick = {selected = !selected},
            label = {Text(text = "Filter Chip")},
            leadingIcon = if(selected) {
                {
                    Icon(Icons.Filled.AccountBox, "", Modifier.size(AssistChipDefaults.IconSize))
                }
            }else{null}
        )
    }
}

@Composable
fun InputExample(text: String,
                 onDimiss: () -> Unit){
    var enable by remember { mutableStateOf(true) }
    if(!enable) return

    InputChip(
        label = {Text(text)},
        selected = enable,
        onClick = {
            onDimiss()
            enable = !enable
        },
        avatar = {
            Icon(
                Icons.Filled.AccountCircle,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

@Composable
fun Progress(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
       LinearProgressIndicator(
           modifier = Modifier.fillMaxWidth()
       )
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

@Composable
fun Sliders(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
       var sliderPosition by remember { mutableStateOf(50f) }
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = {sliderPosition = it},
                steps = 10,
                valueRange = 0f .. 100f
            )
            Text(
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                text = sliderPosition.toString()
            )
        }
    }
}

@Composable
fun Switches(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if(checked2){
                {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "",
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }else {
                null
            }
        )

        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = {checked3 = it}
        )
    }
}

@Composable
fun Badges() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var itemCount by remember { mutableStateOf(0) }
        BadgedBox(badge = {
            if (itemCount > 0) {
                Badge(
                    containerColor = Color.Red,
                    contentColor = Color.White

                ){
                    Text("$itemCount")
                }
            }
        }) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = ""
            )
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Add Item")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickers(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        val currenTime = Calendar.getInstance()

        val timePickerState = rememberTimePickerState(
            initialHour = currenTime.get(Calendar.HOUR_OF_DAY),
            initialMinute = currenTime.get(Calendar.MINUTE),
            is24Hour = true
        )

        Column {
            TimePicker(state = timePickerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickers() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var showDatePicker by remember { mutableStateOf(false) }
        val datePickerState = rememberDatePickerState()
        val selectDate = datePickerState.selectedDateMillis?.let {
            convertMillisToDate(it)
        } ?: ""
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(value = selectDate,
                onValueChange = {},
                label = { Text("DOB")},
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = {showDatePicker = !showDatePicker }) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Select date"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                )

            if(showDatePicker) {
                Popup (onDismissRequest = {showDatePicker = false}, alignment = Alignment.TopStart){

                }
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@Composable
fun SnackBars() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState, Modifier)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message was sent") }
        }

        Button(:: launchSnackBar) {
            Text("Show SnackBar")

        }

    }
}

@Composable
fun AlertDialogs() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog){
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "f")},
                title = { Text(text = "Confirm Deletion") },
                text = { Text(text = "Are you sure you want to delete this file?") },
                onDismissRequest = {},
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirm"
                            showAlertDialog = false
                        }
                    )
                    {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Dismiss"
                            showAlertDialog = false
                        }
                    )
                    {
                        Text(text = "Dismiss")
                    }
                }

            )
        }

        Text(selectedOption)

        Button(onClick = {showAlertDialog = true}){
            Text(text = "Show alert dialog")
        }

    }
}

@Composable
fun Bars(){
    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)
    ){
        Row (modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
            .background(Color.Black)
            .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(Icons.Filled.Menu, contentDescription = "", tint = Color.White )
            Text(
                text = "App Title",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(Icons.Filled.Settings, contentDescription = "", tint = Color.White )

        }

    }
}

