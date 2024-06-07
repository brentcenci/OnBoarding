package com.example.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onboarding.ui.screens.FirstStyle
import com.example.onboarding.ui.screens.Home
import com.example.onboarding.ui.screens.Screen
import com.example.onboarding.ui.screens.SecondStyle
import com.example.onboarding.ui.theme.OnBoardingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnBoardingTheme {

                //Simple Compose Navigation implementation with the standard dependency
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {
                    composable(route = Screen.Home.route) {
                        Home(navController = navController)
                    }
                    composable(route = Screen.First.route) {
                        FirstStyle(navController = navController)
                    }
                    composable(route = Screen.Second.route) {
                        SecondStyle(navController = navController)
                    }
                }
            }
        }
    }
}