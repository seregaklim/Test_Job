package com.seregaklim.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seregaklim.entity.ResponsePEntity
import kotlinx.coroutines.flow.Flow

//@Dao
//interface ResponsePDao  {
//    @Query("SELECT * FROM ResponsePEntity ORDER BY id DESC")
//    fun getAll(): LiveData<List<ResponsePEntity>>
//
//    @Query("SELECT COUNT(*) == 0 FROM ResponsePEntity")
//    suspend fun isEmpty(): Boolean
//
//    @Query("SELECT COUNT(*) FROM ResponsePEntity")
//    suspend fun count(): Int
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(responseP: ResponsePEntity)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(responsePs: List<ResponsePEntity>)
//
//    @Query("DELETE FROM ResponsePEntity WHERE id = :id")
//    suspend fun removeById(id: Long)
//}

@Dao
interface ResponsePDao {
    //записываем
    @Insert
    suspend fun insert(responsePEntity: ResponsePEntity)
    //берем все
    @Query("SELECT * FROM response")
    fun getAll(): LiveData<List<ResponsePEntity>>
    @Delete
    suspend fun delete(responsePEntity: ResponsePEntity)
}