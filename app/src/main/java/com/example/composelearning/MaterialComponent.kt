package com.example.composelearning

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TestMaterial() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
       DialogAlert()
    }
}

@Composable
private fun exButton(){
    OutlinedButton(onClick = {}) {
        Text("Buttons")
    }
}

@Composable
private fun TextInputLayout(){
    OutlinedTextField(
        value = "label",
        onValueChange = {  },
        label = { Text("LABEL") },
        leadingIcon = { },
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    )
}

@Composable
private fun DialogAlert(){
    AlertDialog(
        title = {
            Text(
                text = "Приветы"
            )
        },
        text = {
            Text(
                text = "И тут приветы"
            )
        },
        onDismissRequest = {},
        confirmButton = {
            TextButton(
                onClick = {
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
