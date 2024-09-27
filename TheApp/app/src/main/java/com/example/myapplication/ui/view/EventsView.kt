package com.example.myapplication.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.navigation.Destinations
import com.example.myapplication.ui.components.AppBar
import com.example.myapplication.ui.components.AppFloatingButton
import com.example.myapplication.viewmodel.EventsViewModel

@Composable
fun EventsView(
    navController: NavController,
    viewModel: EventsViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            AppBar(
                "Events"
            ) {
                navController.navigateUp()
            }
        },

        floatingActionButton = {
            AppFloatingButton(title = " Add Events ") {
                navController.navigate(Destinations.AddEventScreen.route)
            }
        },

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}

