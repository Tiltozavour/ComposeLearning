package com.example.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.composelearning.pastLessons.cardInst.MainViewModel
import com.example.composelearning.ui.theme.ComposeLearningTheme
import com.example.composelearning.vkScroll.domain.PostInfo
import com.example.composelearning.vkScroll.domain.StatisticItem
import com.example.composelearning.vkScroll.domain.StatisticType
import com.example.composelearning.vkScroll.presenter.cardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            ComposeLearningTheme {
                cardScreen()
                //TableRow()
                // CardBoxes(viewModel)
                //GetBar()
                //TestMaterial()
                /*   ComposeLearningTheme {
                       Column( //слишком тяжелый, замена
                           modifier = Modifier.fillMaxSize()
                               .background(MaterialTheme.colorScheme.background)
                       ) {  }
                   }*/
            }
        }
    }
}









