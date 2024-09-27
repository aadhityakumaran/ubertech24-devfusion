    package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.view.EventsView
import com.example.myapplication.ui.view.HomeView

@Composable
fun NavGraph (
    navController: NavHostController = rememberNavController()
){
    NavHost(navController = navController, startDestination = Destinations.HomeScreen.route){

        composable(Destinations.HomeScreen.route){
            HomeView(navController)
        }

        composable(Destinations.EventScreen.route) { backStackEntry ->
            val event = backStackEntry.arguments?.getString("event")
            EventsView(event?: "", navController)
        }

        composable(Destinations.AddEventScreen.route) {
            HomeView(navController)
        }
    }
}
