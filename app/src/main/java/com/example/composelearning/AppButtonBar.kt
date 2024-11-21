package com.example.composelearning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun GetBar() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Call, Icons.Default.Build, Icons.Default.Home)
    val selectedItems = remember { mutableStateOf(items[0]) } //стейт запоминается через ремембер (не переживает поворот экрана)
    val snackBarHotState = remember { SnackbarHostState() }
    val fubIsVisible = remember { mutableStateOf(true) } //установка по умолчанию стейка видисиости кноаки фаб
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null)},
                        label = { Text(item.name)},
                        selected = item == selectedItems.value,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            selectedItems.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            Scaffold(topBar = { TopAppNavigation() },
                snackbarHost = {
                    SnackbarHost(
                        hostState = snackBarHotState
                    )
                },
                bottomBar = { BottomNavigation() },
                floatingActionButton = {
                    if (fubIsVisible.value){ //установка visible через вызов-невызов функции (если нужно видимость - вызываем)
                        FloatingActionButton(
                            onClick = {
                                scope.launch {
                                    val stateSnackBar =  snackBarHotState.showSnackbar( //вызываем снэкбар
                                        message = "Hello?", // сообщение снэкбара
                                        actionLabel = "Hide bt", //элемент на снэкбаре
                                        duration = SnackbarDuration.Long // как долго будет снэкбар на экране
                                    )
                                    if (stateSnackBar == SnackbarResult.ActionPerformed){
                                        fubIsVisible.value = false
                                    }
                                }


                            }
                        ) {
                            Icon(Icons.Outlined.Done, null)
                        }
                    }
                },
                content = { padding_values ->
                    LazyColumn(
                        contentPadding = padding_values,
                        verticalArrangement = Arrangement.spacedBy((8.dp))
                    ) {
                    }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "This is box")
                    }
                }
            )
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppNavigation() {
    TopAppBar(
        title = {
            Text(
                text = "TopAppBar",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = {})
            {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "null"
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "null"
                )
            }
        }
    )
}

@Composable
private fun BottomNavigation() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(BotNavItems.Home,BotNavItems.Main,BotNavItems.Profile)
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

