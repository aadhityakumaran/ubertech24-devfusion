package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AppFloatingButton(
    title: String,
    onClick: () -> Unit,
) {
    FloatingActionButton(
        modifier = Modifier.padding(all = 20.dp),
        contentColor = Color.Black,
        containerColor = Color.White,
        onClick = {
            onClick()
        }
    ) {
        Text(text = title)
    }
}