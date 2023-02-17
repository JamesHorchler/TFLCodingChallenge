package com.example.tflcc.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tflcc.model.TrainlineItemModel
import com.example.tflcc.util.Resource

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val list = viewModel.data.collectAsState().value
    var expandedIndex by remember {mutableStateOf(-1)}

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Train Updates",
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontStyle = FontStyle.Italic
        )

        LazyColumn(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            when (list) {
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    itemsIndexed(list.data as List<TrainlineItemModel>) { index, item ->
                        val isExpanded = index == expandedIndex

                        Column(modifier = Modifier
                            .clickable{ expandedIndex = if (isExpanded) -1 else index}
                            .fillMaxWidth()
                            .background(if (isExpanded) Color.LightGray else Color.White)) {


                            TrainItem(item)
                            if(isExpanded) {
                                Text(
                                    text = item.lineStatuses[0].statusSeverityDescription,
                                    modifier = Modifier.padding(16.dp)

                                )
                            }
                        }
                    }
                }
            }

        }
    }
}


