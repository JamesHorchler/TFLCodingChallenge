package com.example.tflcc.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "trains"
)
data class TrainlineItemModel(
//    @SerializedName("created")
//    val created: String = "",
//    @SerializedName("crowding")
//    val crowding: CrowdingModel = CrowdingModel(),
//    @SerializedName("disruptions")
//    val disruptions: List<AnyModel> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("lineStatuses")
    val lineStatuses: List<LineStatuseModel> = listOf(),
    @SerializedName("modeName")
    val modeName: String = "",
    @SerializedName("modified")
    val modified: String = "",
    @PrimaryKey
    @SerializedName("name")
    val name: String = "",
//    @SerializedName("routeSections")
//    val routeSections: List<AnyModel> = listOf(),
    @SerializedName("serviceTypes")
    val serviceTypes: List<ServiceTypeModel> = listOf(),
//    @SerializedName("$type")
//    val type: String = ""
)