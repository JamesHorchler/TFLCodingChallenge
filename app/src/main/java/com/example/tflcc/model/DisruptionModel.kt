package com.example.tflcc.model


import com.google.gson.annotations.SerializedName

data class DisruptionModel(
    @SerializedName("additionalInfo")
    val additionalInfo: String = "",
//    @SerializedName("affectedRoutes")
//    val affectedRoutes: List<AnyModel> = listOf(),
//    @SerializedName("affectedStops")
//    val affectedStops: List<AnyModel> = listOf(),
    @SerializedName("category")
    val category: String = "",
    @SerializedName("categoryDescription")
    val categoryDescription: String = "",
    @SerializedName("closureText")
    val closureText: String = "",
    @SerializedName("created")
    val created: String = "",
    @SerializedName("description")
    val description: String = "",
//    @SerializedName("$type")
//    val type: String = ""
)