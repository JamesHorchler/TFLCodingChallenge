package com.example.tflcc.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tflcc.model.LineStatuseModel
import com.example.tflcc.model.Trainline
import com.example.tflcc.model.TrainlineItemModel
import com.example.tflcc.util.Converters


@Database(
    entities = [TrainlineItemModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TrainsDatabase: RoomDatabase() {
    abstract fun getDao(): TrainDao
}