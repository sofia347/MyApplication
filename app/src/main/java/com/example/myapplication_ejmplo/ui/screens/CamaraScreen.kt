package com.example.myapplication_ejmplo.ui.screens

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication_ejmplo.ui.Camara.rememberCameraLauncher
import com.example.myapplication_ejmplo.ui.Camara.rememberGalleryLauncher
import com.example.myapplication_ejmplo.ui.Camara.rememberPermissionLauncher
import com.example.myapplication_ejmplo.ui.Camara.requestPermissions

@Composable
fun CamaraScreen(context: Context) {
    val imageUris = remember { mutableStateListOf<Uri>() }

    // Lanzadores de funcionalidad y permisos
    val permissionLauncher = rememberPermissionLauncher(context) { granted ->
        if (!granted) return@rememberPermissionLauncher
    }

    val cameraLauncher = rememberCameraLauncher(context) { uri ->
        uri?.let { imageUris.add(it) }
    }

    val galleryLauncher = rememberGalleryLauncher { uri ->
        uri?.let { imageUris.add(it) }
    }

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(imageUris) { uri ->
                    Box(modifier = Modifier.padding(bottom = 10.dp)) {
                        // Obtener el bitmap de la URI utilizando BitmapFactory
                        val bitmap = BitmapFactory.decodeStream(context.contentResolver.openInputStream(uri))
                        bitmap?.let {
                            Image(
                                bitmap = it.asImageBitmap(),
                                contentDescription = "Imagen tomada o seleccionada",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        }

                        IconButton(
                            onClick = { imageUris.remove(uri) },
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(36.dp)
                                .padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Eliminar imagen",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FloatingActionButton(
                    onClick = {
                        requestPermissions(context, permissionLauncher) {
                            cameraLauncher.launch(null)
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "Abrir cámara"
                    )
                }

                FloatingActionButton(
                    onClick = {
                        requestPermissions(context, permissionLauncher) {
                            galleryLauncher.launch("image/*")
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Importar Imagen"
                    )
                }

                FloatingActionButton(
                    onClick = { imageUris.clear() },
                    containerColor = MaterialTheme.colorScheme.error,
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Eliminar todas las imágenes"
                    )
                }
            }
        }
    }
}