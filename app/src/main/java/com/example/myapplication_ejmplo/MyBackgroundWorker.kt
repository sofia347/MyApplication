package com.example.myapplication_ejmplo

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.Data

class MyBackgroundWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        // Simulando una lista de números
        val numbers = (1..1000).toList()

        // Contando números pares
        val evenCount = numbers.count { it % 2 == 0 }

        // Guardar el resultado en Data
        val outputData = Data.Builder()
            .putInt("evenCount", evenCount)
            .build()

        // Retornar éxito con el resultado
        return Result.success(outputData)
    }
}
