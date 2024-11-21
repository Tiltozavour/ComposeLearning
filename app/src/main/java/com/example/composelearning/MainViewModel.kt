package com.example.composelearning

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel:ViewModel() {

    var isFollowing =  MutableStateFlow(false)
        private set
    init {
        isFollowing
    }

    fun changeFollowingState(){
        isFollowing.value = !isFollowing.value
    }
}