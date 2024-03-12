package com.example.dedeepsingu_3200midtermtimers

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dedeepsingu_3200midtermtimers.screens.MainScreen
import com.example.dedeepsingu_3200midtermtimers.screens.LeftScreen
import com.example.dedeepsingu_3200midtermtimers.screens.RightScreen
import com.example.dedeepsingu_3200midtermtimers.screens.ScreenRoutes
import com.example.dedeepsingu_3200midtermtimers.timers.LeftScreenViewModel
import com.example.dedeepsingu_3200midtermtimers.timers.MainScreenViewModel
import com.example.dedeepsingu_3200midtermtimers.timers.RightScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val mainScreenViewModel: MainScreenViewModel = viewModel()
    val leftScreenViewModel: LeftScreenViewModel = viewModel()
    val rightScreenViewModel: RightScreenViewModel = viewModel()

    NavHost(navController = navController, startDestination = ScreenRoutes.MainScreen.route) {
        composable(route = ScreenRoutes.MainScreen.route) {
            MainScreen(navController = navController, viewModel = mainScreenViewModel)
        }
        composable(route = ScreenRoutes.LeftScreen.route) {
            LeftScreen(navController = navController, viewModel = leftScreenViewModel)
        }
        composable(route = ScreenRoutes.RightScreen.route) {
            RightScreen(navController = navController, viewModel = rightScreenViewModel)
        }
    }
}