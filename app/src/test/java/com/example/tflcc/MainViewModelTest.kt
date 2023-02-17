package com.example.tflcc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tflcc.model.LineStatuseModel
import com.example.tflcc.model.TrainlineItemModel
import com.example.tflcc.repository.Repository
import com.example.tflcc.ui.MainViewModel
import com.example.tflcc.util.Resource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository

    @Before
    fun setup() {
        repository = mock(Repository::class.java)
        viewModel = MainViewModel(repository)
    }

    @Test
    fun `when getData is called, it should emit Resource Success`() = runBlocking {
        // given
        val fakeResponse = Response.success(listOf(
            TrainlineItemModel("1", listOf(LineStatuseModel("Good Service")))
        ))
        `when`(repository.getTrainsInfo()).thenReturn(fakeResponse)

        // when
        viewModel.getData()

        // then
        val result = viewModel.data.first()
        assert(result is Resource.Success)
        assert((result as Resource.Success).data?.size == 1)
    }
}
