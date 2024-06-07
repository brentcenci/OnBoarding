package com.example.onboarding.ui.screens

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object First : Screen("first")
    data object Second : Screen("second")
    data object Third : Screen("third")
}