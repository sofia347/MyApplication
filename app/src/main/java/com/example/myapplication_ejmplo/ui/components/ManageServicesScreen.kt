package com.example.myapplication_ejmplo.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication_ejmplo.R
import com.example.myapplication_ejmplo.data.model.Controller.ServiceViewModel
import com.example.myapplication_ejmplo.data.model.ServiceEntity
import com.example.myapplication_ejmplo.data.model.ServiceModel
import com.example.myapplication_ejmplo.data.model.dao.ServiceDao
import com.example.myapplication_ejmplo.data.model.database.AppDatabase
import com.example.myapplication_ejmplo.data.model.database.DatabaseProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun ManageServiceScreen(
    navController : NavController,
    serviceId: String?,
    viewModel: ServiceViewModel = viewModel()
){
    val service = remember {mutableStateOf(ServiceModel())}
    val context = LocalContext.current
    var bar_title by remember {mutableStateOf("Create new service")}

    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val serviceDao = db.serviceDao()

    if (serviceId != null && serviceId != "0") {
        bar_title = "Update service"
        viewModel.showService(db, serviceId.toInt()) { entity ->
            if (entity != null) {
                // Actualizar los valores del estado con los datos recuperados
                service.value.name = entity.name
                service.value.username = entity.username
                service.value.password = entity.password
                service.value.description = entity.description
            } else {
                // Mostrar un mensaje si no se pudo cargar el servicio
                Toast.makeText(
                    context,
                    "Failed to load a service",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    Scaffold(
        topBar = {TopBar(bar_title, navController, true)},
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.black))
                .padding(innerPadding)
        ){
            Spacer(modifier = Modifier.padding(0.dp, 5.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = service.value.name,
                maxLines = 1,
                onValueChange = { service.value = service.value.copy(name = it) },
                label = { Text("Service name") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = colorResource(R.color.purple_500),
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = colorResource(R.color.black),
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    unfocusedSupportingTextColor = Color.LightGray,
                    focusedTextColor = Color.White,
                    focusedLabelColor = Color.White
                ),
            )

// Campo: Nombre de usuario
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = service.value.username,
                maxLines = 1,
                onValueChange = { service.value = service.value.copy(username = it) },
                label = { Text("Username") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = colorResource(R.color.purple_500),
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = colorResource(R.color.black),
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    unfocusedSupportingTextColor = Color.LightGray,
                    focusedTextColor = Color.White,
                    focusedLabelColor = Color.White
                ),
            )

// Campo: Contraseña
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = service.value.password,
                maxLines = 1,
                onValueChange = { service.value = service.value.copy(password = it) },
                label = { Text("Password") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = colorResource(R.color.purple_500),
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = colorResource(R.color.black),
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    unfocusedSupportingTextColor = Color.LightGray,
                    focusedTextColor = Color.White,
                    focusedLabelColor = Color.White
                ),
            )

// Campo: Descripción
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = service.value.description,
                maxLines = 1,
                onValueChange = { service.value = service.value.copy(description = it) },
                label = { Text("Description") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedBorderColor = colorResource(R.color.purple_500),
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = colorResource(R.color.black),
                    unfocusedTextColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    unfocusedSupportingTextColor = Color.LightGray,
                    focusedTextColor = Color.White,
                    focusedLabelColor = Color.White
                ),
            )
            FilledTonalButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.purple_500),
                    contentColor = Color.Black,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp),
                shape = CutCornerShape(4.dp),
                onClick = {
                    val db: AppDatabase = DatabaseProvider.getDatabase(context)
                    val serviceTemp = ServiceModel(
                        name = service.value.name,
                        username = service.value.username,
                        password = service.value.password,
                        description = service.value.description
                    )
                    save(viewModel, db, context, serviceTemp, serviceId)
                }
            ) {
                Text(if (serviceId == "0") "CREATE SERVICE" else "SAVE CHANGES")
            }

            if (serviceId != null && serviceId.toInt() > 0) {
                OutlinedButton(
                    border = BorderStroke(
                        width = 3.dp,
                        color = colorResource(R.color.purple_500)
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 10.dp),
                    shape = CutCornerShape(4.dp),
                    onClick = {
                        delete(viewModel, context, serviceId, navController, serviceDao)
                    }
                ) {
                    Text("DELETE")
                }
            }
        }
    }
}

fun save(
    viewModel: ServiceViewModel,
    db: AppDatabase,
    context: Context,
    service: ServiceModel,
    serviceId: String?
) {
    val serviceDao = db.serviceDao()

    if (serviceId == "0") {
        // Crear un nuevo servicio
        viewModel.createService(service, db) { success ->
            if (success) {
                Toast.makeText(
                    context,
                    "Service created successfully",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    context,
                    "Failed to create service",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    } else {
        // Actualizar un servicio existente
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val updatedEntity = ServiceEntity(
                    id = serviceId!!.toInt(),
                    name = service.name,
                    username = service.username,
                    password = service.password,
                    description = service.description,
                    imageURL = service.imageURL,
                )
                serviceDao.update(updatedEntity) // Actualizar en la BD local
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Service updated successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Failed to update service: ${exception.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}


fun delete(
    viewModel: ServiceViewModel,
    context: Context,
    serviceId: String?,
    navController: NavController,
    serviceDao: ServiceDao
) {
    if (serviceId != null && serviceId != "0") {
        CoroutineScope(Dispatchers.IO).launch {
            val service = serviceDao.show(serviceId.toInt())
            if (service != null) {
                serviceDao.delete(service)
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(
                        context,
                        "Service deleted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    navController.popBackStack()
                }
            } else {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(
                        context,
                        "Failed to delete service: Service not found",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
