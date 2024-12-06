package com.example.composelearning.pastLessons.appNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composelearning.R

sealed class BotNavItems(
    val resId: Int,
    val icon: ImageVector
) {
    data object Home : BotNavItems(
        resId = R.string.home_bot,
        icon = Icons.Outlined.Home
    )

    data object Main : BotNavItems(
        resId = R.string.main_bot,
        icon = Icons.Outlined.Build
    )

    data object Profile : BotNavItems(
        resId = R.string.profile_bot,
        icon = Icons.Outlined.Person
    )
}