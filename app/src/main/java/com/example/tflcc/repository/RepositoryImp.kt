package com.example.tflcc.repository

import android.util.Log
import com.example.tflcc.api.TrainsApi
import com.example.tflcc.database.TrainDao
import com.example.tflcc.model.LineStatuseModel
import com.example.tflcc.model.Trainline
import com.example.tflcc.model.TrainlineItemModel
import com.example.tflcc.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val trainsApi: TrainsApi
): Repository{
    override suspend fun getTrainsInfo(): Response<List<TrainlineItemModel>> {
        return trainsApi.getTrains()
    }
}