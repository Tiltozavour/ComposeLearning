package com.example.composelearning.pastLessons.cardInst

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelearning.R

@Composable
 fun GetLazyColumn(
    viewModel: MainViewModel
 ){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        val models by viewModel.instModel.collectAsState(listOf())
        models.let { models ->
            LazyColumn() {
                items(items = models, key = {it.id}) { model ->
                    CardBoxes(
                        instModel = model,
                        onFollowClickListener = {viewModel.changeFollowingState(it)}
                    )
                }
            }
        }
    }
}



@SuppressLint("StateFlowValueCalledInComposition")
@Composable
private fun CardBoxes(
    instModel: InstModel,
    onFollowClickListener:(InstModel) -> Unit ) {
    //val isFollowed = viewModel.isFollowing.collectAsState(initial = false) //рекомпазиция только для кнопки
   // val isFollowed by viewModel.isFollowing.collectAsState(initial = false) // рекомпазиция не только кнопки но и контйнера кард

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
            Image(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "Описание картинки",
                modifier = Modifier.clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surface)
            )


            TitleInfo(title = "Post", value = "0000")
            TitleInfo(title = "Followers", value = "0001")
            TitleInfo(title = "Folowing", value = "0000")

        }
        TextInfo(info = instModel.title, 24.sp)
        TextInfo("#Хешег", 14.sp)
        TextInfo("Описание очеь длинное и капец какое интересное",12.sp)
        ButtonsClick(isFollowed = instModel.isFollowing){
            onFollowClickListener(instModel)
        }
    }

}

@Composable
private fun ButtonsClick(
    isFollowed:Boolean,
    clickListener: () -> Unit
){
    Button(
        onClick = { clickListener() },
        modifier = Modifier.padding(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
    {
        val text = if (isFollowed) { "Unfollow" } else { "Follow" }
        Text(text = text)
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

@Composable
private fun TextInfo(info:String, size: TextUnit){
    Column(modifier = Modifier.padding(start = 34.dp, bottom = 4.dp)) {
        Text(
            text = info,
            fontSize = size,
            fontFamily = FontFamily.Monospace
        )
    }

}



