package com.example.composelearning

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.composelearning.ui.theme.ComposeLearningTheme
import com.example.composelearning.vkScroll.presenter.VkCardViewModel
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.composelearning.pastLessons.cardInst.GetLazyColumn
import com.example.composelearning.pastLessons.cardInst.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<VkCardViewModel>()
    private val viewModelMain by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLearningTheme {
                // CardScreen(viewModel)
                //TableRow()
                GetLazyColumn(
                    viewModel = viewModelMain
                )
            }
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










