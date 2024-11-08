package com.example.composelearning.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun CardBoxes() {
    Card(
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(2.dp, color = Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth() //Ширина
                // .fillMaxHeight() //Высота
                .height(height = 80.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box( //первая коробка
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.LightGray)
                    .border(width = 4.dp, color = Color.DarkGray)
            )

            doubleBoxes()
            doubleBoxes()
            doubleBoxes()
        }
    }

}


@Composable
private fun doubleBoxes() {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    )
    {
        Box(
            modifier = Modifier
                .size(30.dp)
                .border(width = 2.dp, Color.DarkGray)
                .background(Color.LightGray)
        )
        Box(
            modifier = Modifier
                .size(30.dp)
                .border(width = 2.dp, Color.DarkGray)
                .background(Color.LightGray)
        )


    }

}