package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph (
    navController: NavHostController = rememberNavController()
){
    NavHost(navController = navController, startDestination = Destinations.HomeScreen.route){

        composable(Destinations.HomeScreen.route){

        }

        composable(Destinations.EventScreen.route) {

        }
    }
}
