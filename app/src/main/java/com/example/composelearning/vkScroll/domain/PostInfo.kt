package com.example.composelearning.vkScroll.domain

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.composelearning.R

data class PostInfo(
    val usName:String = "Empathy",
    val timeInf:String = "04:04",
    val textCookie:String = "Оставь руины прошлого позади",
    val resIdAva:Int = R.drawable.jpg_ex,
    val resIdContent:Int = R.drawable.ic_empathy_jpg,
    val statistics:List<StatisticItem> = listOf(
        StatisticItem(typeStatic = StatisticType.VIEWS, 69),
        StatisticItem(typeStatic = StatisticType.SHARES, 69),
        StatisticItem(typeStatic = StatisticType.COMMENTS, 69),
        StatisticItem(typeStatic = StatisticType.LIKES, 69)
    )
)