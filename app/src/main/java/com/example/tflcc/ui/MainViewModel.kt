package com.example.tflcc.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tflcc.model.TrainlineItemModel
import com.example.tflcc.repository.Repository
import com.example.tflcc.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _data: MutableStateFlow<Resource<List<TrainlineItemModel>>> =
        MutableStateFlow(Resource.Loading())
    var data: StateFlow<Resource<List<TrainlineItemModel>>> = _data

    init {
        getData()
    }

    private fun handleResponse(response: Response<List<TrainlineItemModel>>): Resource<List<TrainlineItemModel>> {
        return if (response.isSuccessful) Resource.Success(response.body()!!)
        else Resource.Error(response.message())
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _data.emit(Resource.Loading())
                val response = repository.getTrainsInfo()
                _data.emit(handleResponse(response))
            } catch (e: HttpException) {
                Log.i("error", "Error here")
            } catch (e: IOException) {
                Log.i("error", "Another error")
            }
        }
    }
}