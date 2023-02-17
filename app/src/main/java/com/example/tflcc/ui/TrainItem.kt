package com.example.tflcc.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tflcc.model.TrainlineItemModel

@Composable
fun TrainItem(item: TrainlineItemModel) {
    val hashMap = hashMapOf<String, String>(
        "bakerloo" to "#894E24",
        "central" to "#DC241F",
        "circle" to "#FFCE00",
        "district" to "#007229",
        "hammersmith-city" to "#D799AF",
        "jubilee" to "#697278",
        "metropolitan" to "#751056",
        "northern" to "#000000",
        "piccadilly" to "#001AA8",
        "victoria" to "#01A0E2",
        "waterloo-city" to "#76D0BD"
    )
    Card(
        modifier = Modifier
            .border(1.dp, Color.LightGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "",
                modifier = Modifier
                    .background(
                        Color(
                            android.graphics.Color.parseColor
                                (hashMap[item.id] ?: "#000000")
                        )
                    )
                    .size(width = 20.dp, height = 60.dp)
            )

            Text(
                text = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                fontSize = 20.sp

            )
        }
    }
}