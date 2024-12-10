package com.example.composelearning.pastLessons.cardInst

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class MainViewModel:ViewModel() {

/*    var isFollowing =  MutableStateFlow(false)
        private set*/

    var instModel = MutableStateFlow<List<InstModel>>(emptyList())
        private set

    init {
        initListInstModel()
    }

    fun changeFollowingState(model: InstModel){
        val modifyList = instModel.value.toMutableList()
        modifyList.replaceAll {
            if (it == model){
                it.copy(isFollowing = !it.isFollowing)
            }
            else{
                it
            }
        }
        instModel.value = modifyList
    }

   private fun initListInstModel(){
        val list = List(30){ index ->
            InstModel(id = index,
                title = "Title $index",
                isFollowing = Random.nextBoolean())
        }
        instModel.value = list
    }

}