package com.example.composelearning.vkScroll.domain

data class StatisticItem(
    val typeStatic : StatisticType,
    val count:Int = 0
)

enum class StatisticType{
    VIEWS, COMMENTS, SHARES,LIKES
}