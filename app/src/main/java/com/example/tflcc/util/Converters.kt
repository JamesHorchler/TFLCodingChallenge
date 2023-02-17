package com.example.tflcc.util

import androidx.room.TypeConverter
import com.example.tflcc.model.LineStatuseModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromLineStatuses(lineStatuses: List<LineStatuseModel>): String {
        return Gson().toJson(lineStatuses)
    }

    @TypeConverter
    fun toLineStatuses(lineStatusesString: String): List<LineStatuseModel> {
        val type = object : TypeToken<List<LineStatuseModel>>() {}.type
        return Gson().fromJson(lineStatusesString, type)
    }
}