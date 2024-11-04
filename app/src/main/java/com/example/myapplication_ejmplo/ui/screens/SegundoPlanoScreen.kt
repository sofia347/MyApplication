import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.myapplication_ejmplo.MyBackgroundWorker

@Composable
fun SegundoPlanoScreen(navController: NavController) {
    MainContent(navController)
}

@Composable
fun MainContent(navController: NavController) {
    val context = LocalContext.current // Obtener el contexto
    val workManager = WorkManager.getInstance(context)
    var statusMessage by remember { mutableStateOf("Presiona el botón para contar números pares.") }
    var showAlert by remember { mutableStateOf(false) }
    var evenCount by remember { mutableStateOf(0) }

    val workRequest = OneTimeWorkRequestBuilder<MyBackgroundWorker>()
        .build()

    // Observe el estado del trabajo
    LaunchedEffect(Unit) {
        workManager.enqueue(workRequest)
        workManager.getWorkInfoByIdLiveData(workRequest.id).observeForever { workInfo ->
            if (workInfo != null && workInfo.state.isFinished) {
                evenCount = workInfo.outputData.getInt("evenCount", 0)
                statusMessage = "Tarea completada."
                showAlert = true
            }
        }
    }

    Column {
        Text(text = statusMessage)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {navController.navigate("menu")}){Text(text = "REGRESAR") }

        if (showAlert) {
            AlertDialog(
                onDismissRequest = { showAlert = false },
                title = { Text("Tarea Completada") },
                text = { Text("Total de números pares: $evenCount") },
                confirmButton = {
                    Button(onClick = { showAlert = false }) {
                        Text("Aceptar")
                    }
                }
            )
        }
    }
}
