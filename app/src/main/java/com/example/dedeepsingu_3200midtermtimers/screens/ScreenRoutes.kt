package com.example.dedeepsingu_3200midtermtimers.screens

sealed class ScreenRoutes(val route: String) {
    data object MainScreen : ScreenRoutes("mainScreen")
    data object LeftScreen : ScreenRoutes("leftScreen")
    data object RightScreen : ScreenRoutes("rightScreen")
}

