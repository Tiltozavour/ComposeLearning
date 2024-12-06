package com.example.composelearning.pastLessons.cardInst

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