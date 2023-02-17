package com.example.tflcc.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class LineStatuseModel(
    @SerializedName("created")
    val created: String = "",
    @PrimaryKey
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("lineId")
    val lineId: String = "",
    @SerializedName("reason")
    val reason: String = "",
    @SerializedName("statusSeverity")
    val statusSeverity: Int = 0,
    @SerializedName("statusSeverityDescription")
    val statusSeverityDescription: String = "",
)