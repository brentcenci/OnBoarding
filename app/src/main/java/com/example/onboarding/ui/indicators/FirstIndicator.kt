package com.example.onboarding.ui.indicators

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.onboarding.OnboardingState

@Composable
fun FirstIndicator(modifier: Modifier = Modifier, state: OnboardingState) {
    Row(modifier = modifier) {
        repeat(state.numScreens) {
            val weight = if (it == state.currentScreen) 3f else 1f
            val color = if (it == state.currentScreen) Color(13,110,253,255) else Color.White
            Box(modifier = Modifier
                .padding(horizontal = 2.dp)
                .clip(RoundedCornerShape(50))
                .background(color)
                .height(8.dp)
                .weight(weight)
                .clickable {
                    state.goTo(it)
                }
            )
        }
    }
}