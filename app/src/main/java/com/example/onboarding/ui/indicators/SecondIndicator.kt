package com.example.onboarding.ui.indicators

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.onboarding.OnboardingState

@Composable
fun SecondIndicator(modifier: Modifier = Modifier, state: OnboardingState) {
    Row(modifier = modifier) {
        repeat(state.numScreens) {
            val color = if (it == state.currentScreen) Color(245, 69, 83,255) else Color.LightGray
            Box(modifier = Modifier
                .padding(horizontal = 2.dp)
                .clip(RoundedCornerShape(50))
                .background(color)
                .size(16.dp)
                .clickable {
                    state.goTo(it)
                }
            )
        }
    }
}