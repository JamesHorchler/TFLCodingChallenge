package com.example.tflcc.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tflcc.model.LineStatuseModel
import com.example.tflcc.model.Trainline
import com.example.tflcc.model.TrainlineItemModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTrains(trains: List<TrainlineItemModel>)

    @Query("SELECT * FROM trains")
    fun getAllTrains(): List<TrainlineItemModel>
}