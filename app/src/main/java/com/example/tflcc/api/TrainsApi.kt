package com.example.tflcc.api

import com.example.tflcc.model.LineStatuseModel
import com.example.tflcc.model.Trainline
import com.example.tflcc.model.TrainlineItemModel
import com.example.tflcc.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface TrainsApi {

    @GET(ApiReferences.END_POINT_TRAINS)
    suspend fun getTrains(): Response<List<TrainlineItemModel>>
}