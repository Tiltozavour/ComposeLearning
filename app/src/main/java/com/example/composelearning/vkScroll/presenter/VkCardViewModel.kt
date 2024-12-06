package com.example.composelearning.vkScroll.presenter

import androidx.lifecycle.ViewModel
import com.example.composelearning.vkScroll.domain.PostInfo
import com.example.composelearning.vkScroll.domain.StatisticItem
import kotlinx.coroutines.flow.MutableStateFlow

class VkCardViewModel:ViewModel() {

    var post = MutableStateFlow(PostInfo())
        private set

    fun getUpdateCount(item:StatisticItem){
        val oldStatist = post.value.statistics
        val newStatist = oldStatist.toMutableList().apply {
            replaceAll{ oldValue ->
                if(oldValue.typeStatic == item.typeStatic){
                    oldValue.copy(count = oldValue.count+1)
                } else {
                    oldValue
                }
            }
        }
        post.value = post.value.copy(statistics = newStatist)
    }


}