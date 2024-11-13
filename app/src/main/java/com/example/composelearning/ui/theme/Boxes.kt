package com.example.composelearning.ui.theme

import android.content.res.Resources.Theme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun CardBoxes() {
    Card(
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.onBackground),
        modifier = Modifier.padding(0.dp, 40.dp,)
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

            TitleInfo(title = "Post", value = "0000")
            TitleInfo(title = "Followers", value = "0001")
            TitleInfo(title = "Folowing", value = "0000")
        }
    }

}


@Composable
private fun TitleInfo(title:String, value: String) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    )
    {
        Text(
            text = title,
            fontFamily = FontFamily.Serif,
            fontSize = 18.sp
        )
        Text(
            text = value,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold

        )
    }

}

@Preview
@Composable
private fun CardLight(){
    ComposeLearningTheme(darkTheme = false) {

        CardBoxes()
    }

}

@Preview
@Composable
private fun CardDark(){
    ComposeLearningTheme(darkTheme = true) {
        CardBoxes()
    }
}