package com.example.composelearning.vkScroll.presenter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.composelearning.pastLessons.appNav.BotNavItems
import com.example.composelearning.vkScroll.domain.PostInfo
import com.example.composelearning.vkScroll.domain.StatisticItem
import com.example.composelearning.vkScroll.domain.StatisticType


@Composable
fun CardScreen(viewModel: VkCardViewModel) {

    val post = viewModel.post.collectAsState()

    Scaffold(
        bottomBar = { BottomNavigation() },
        content = { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues,
                verticalArrangement = Arrangement.Center
            ) {

            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                ContentCard(
                    post = post.value,
                    onCommentBotClick = viewModel::getUpdateCount,
                    onShareBotClick = viewModel::getUpdateCount,
                    onViewBotClick = viewModel::getUpdateCount,
                    onLikeBotClick = {
                        viewModel.getUpdateCount(it)
                    }
                )
            }

        }
    )
}


@Composable
private fun BottomNavigation(
) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(BotNavItems.Home, BotNavItems.Main, BotNavItems.Profile)
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(item.icon, null)
                },
                label = { Text(text = stringResource(id = item.resId)) },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                alwaysShowLabel = false
            )
        }
    }
}
