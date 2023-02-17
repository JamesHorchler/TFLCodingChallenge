package com.example.tflcc.repository

import com.example.tflcc.model.LineStatuseModel
import com.example.tflcc.model.Trainline
import com.example.tflcc.model.TrainlineItemModel
import com.example.tflcc.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {

    suspend fun getTrainsInfo(): Response<List<TrainlineItemModel>>
}