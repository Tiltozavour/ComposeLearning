package com.example.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.composelearning.ui.theme.ComposeLearningTheme
import com.example.composelearning.vkScroll.presenter.VkCardViewModel
import com.example.composelearning.vkScroll.presenter.cardScreen
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<VkCardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLearningTheme {
                cardScreen(viewModel)
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









