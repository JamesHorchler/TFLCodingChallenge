package com.example.tflcc.util

import androidx.room.TypeConverter
import com.example.tflcc.model.DisruptionModel
import com.example.tflcc.model.LineStatuseModel
import com.example.tflcc.model.ServiceTypeModel
import com.example.tflcc.model.ValidityPeriodModel
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

    @TypeConverter
    fun fromServiceTypes(serviceTypes: List<ServiceTypeModel>): String {
        return Gson().toJson(serviceTypes)
    }

    @TypeConverter
    fun toServiceTypes(serviceTypesString: String): List<ServiceTypeModel> {
        val type = object : TypeToken<List<ServiceTypeModel>>() {}.type
        return Gson().fromJson(serviceTypesString, type)
    }

    @TypeConverter
    fun fromDisruption(disruption: DisruptionModel): String {
        return Gson().toJson(disruption)
    }

    @TypeConverter
    fun toDisruption(disruptionString: String): DisruptionModel {
        val type = object : TypeToken<DisruptionModel>() {}.type
        return Gson().fromJson(disruptionString, type)
    }

    @TypeConverter
    fun fromValidityPeriods(validityPeriods: List<ValidityPeriodModel>): String {
        return Gson().toJson(validityPeriods)
    }

    @TypeConverter
    fun toValidityPeriods(validityPeriodsString: String): List<ValidityPeriodModel> {
        val type = object : TypeToken<List<ValidityPeriodModel>>() {}.type
        return Gson().fromJson(validityPeriodsString, type)
    }
}