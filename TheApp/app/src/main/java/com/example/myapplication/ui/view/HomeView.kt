package com.example.myapplication.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.navigation.Destinations
import com.example.myapplication.ui.components.AppBar
import com.example.myapplication.ui.components.AppFloatingButton
import com.example.myapplication.viewmodel.HomeViewModel
import com.example.myapplication.ui.components.CategoriesCard

@Composable
fun HomeView(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {

    Scaffold(
        topBar = {
            AppBar(
                "Home"
            ) {
                navController.navigateUp()
            }
        },

        floatingActionButton = {
            AppFloatingButton(
                "Add Event "
            ) {
                navController.navigate(Destinations.EventScreen.route)
            }
        },

        containerColor = Color.Black

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(viewModel.categories) { category ->
                CategoriesCard(
                    event = category,
                    onclick = {
                        navController.navigate(Destinations.EventScreen.createRoute(event = category))
                    }
                )
            }
        }
    }
}

