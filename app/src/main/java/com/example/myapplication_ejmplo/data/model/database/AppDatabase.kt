package com.example.myapplication_ejmplo.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication_ejmplo.data.model.ServiceEntity
import com.example.myapplication_ejmplo.data.model.dao.ServiceDao

@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun serviceDao(): ServiceDao
}