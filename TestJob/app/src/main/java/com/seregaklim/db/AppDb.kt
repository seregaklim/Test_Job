package com.seregaklim.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.seregaklim.dao.ResponsePDao
import com.seregaklim.entity.ResponsePEntity

@Database(entities = [ResponsePEntity::class], version = 1, exportSchema = false)
abstract class MainDb : RoomDatabase() {
    abstract fun postDao():  ResponsePDao

    companion object {
        @Volatile
        private var instance:MainDb? = null

        fun getInstance(context: Context): MainDb {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MainDb::class.java, "app.db")
                //.allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}