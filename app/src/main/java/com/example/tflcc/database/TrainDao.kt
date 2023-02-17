package com.example.tflcc.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tflcc.model.TrainlineItemModel

@Dao
interface TrainDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTrains(trains: List<TrainlineItemModel>)

    @Query("SELECT * FROM trains")
    fun getAllTrains(): List<TrainlineItemModel>
}