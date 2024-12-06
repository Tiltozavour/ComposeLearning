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
fun cardScreen() {

    val post = remember {
        mutableStateOf(PostInfo())
    }

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
                    clickItemBottom = { newValue ->
                        val oldStatist = post.value.statistics
                        val newStatist = oldStatist.toMutableList().apply {
                            replaceAll{ oldValue ->
                                if(oldValue.typeStatic == newValue.typeStatic){
                                    oldValue.copy(count = oldValue.count+1)
                                } else {
                                    oldValue
                                }
                            }
                        }
                        post.value = post.value.copy(statistics = newStatist)

                    }
                )
            }

        }
    )
}




@Composable
private fun ContentCard(
    post: PostInfo,
    clickItemBottom: (StatisticItem) -> Unit
) {
    Card(
        modifier = Modifier.padding(8.dp),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = post.resIdAva),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                TextInput(text = post.usName)
                TextInput(post.timeInf)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }
        TextInput(text = post.textCookie)
        Image(
            modifier = Modifier
                .padding(14.dp, 8.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(post.resIdContent),
            contentDescription = null
        )
        BottomStroke(
            statistic =  post.statistics,
            onItemBotClick = clickItemBottom

        )
    }
}


@Composable
private fun BottomStroke(
    statistic: List<StatisticItem>,
    onItemBotClick: (StatisticItem) -> Unit
) {
    Row(modifier = Modifier.padding(14.dp, 8.dp))
    {
        val viewItem = statistic.getItemByType(StatisticType.VIEWS)
        val sharesItem = statistic.getItemByType(StatisticType.SHARES)
        val commentsItem = statistic.getItemByType(StatisticType.COMMENTS)
        val likesItem = statistic.getItemByType(StatisticType.LIKES)

        IconWithText(
            icon = Icons.Outlined.Face,
            text = viewItem.count.toString(),
            onItemBotClick = { onItemBotClick(viewItem) }
        )

        IconWithText(
            icon = Icons.Outlined.PlayArrow,
            text = sharesItem.count.toString(),
            onItemBotClick = { onItemBotClick(sharesItem) }
        )
        IconWithText(
            icon = Icons.Outlined.Email,
            text = commentsItem.count.toString(),
            onItemBotClick = { onItemBotClick(commentsItem) }

        )
        IconWithText(
            icon = Icons.Outlined.Favorite,
            text = likesItem.count.toString(),
            onItemBotClick = { onItemBotClick(likesItem) }
        )
    }

}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.typeStatic == type } ?: throw IllegalStateException("Девачки, вы упали!")
}

@Composable
private fun IconWithText(
    icon: ImageVector,
    text: String,
    onItemBotClick: () -> Unit
) {
    Row(modifier = Modifier.clickable {
        onItemBotClick()
    }){
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        TextInput(text)
    }

}


@Composable
private fun TextInput(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(14.dp, 4.dp),
        color = MaterialTheme.colorScheme.onBackground,
        fontFamily = FontFamily.Monospace
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
