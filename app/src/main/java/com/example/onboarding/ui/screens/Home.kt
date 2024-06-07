package com.example.onboarding.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavController) {
    Column {
        Button(onClick = { navController.navigate(Screen.First.route) }) {
            Text("Go to the First example")
        }
        Button(onClick = { navController.navigate(Screen.Second.route) }) {
            Text("Go to the Second example")
        }
    }
}