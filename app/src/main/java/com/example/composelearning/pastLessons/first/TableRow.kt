package com.example.composelearning.pastLessons.first

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

    @Preview
    @Composable
    fun TableRow() {
        Column(modifier = Modifier.fillMaxSize())
        {
            for (i in 1..10) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                )
                {
                    for (k in 1..10) {
                        val color = if ((i + k) % 2 == 0) Color.Gray else Color.LightGray
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f)
                                .border(width = 1.dp, color = Color.LightGray)
                                .background(color = color),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("${i * k}")
                        }
                    }
                }
            }

        }
    }
