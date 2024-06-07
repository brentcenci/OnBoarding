package com.example.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class OnboardingState(
    val currentScreen: Int = 0,
    val numScreens: Int,
    val goNext: () -> Unit = { },
    val goBack: () -> Unit = { },
    val goTo: (Int) -> Unit = { }
)

@Composable
fun rememberOnboardingState(numScreens: Int): MutableState<OnboardingState> {
    val state = remember { mutableStateOf(OnboardingState(numScreens = numScreens)) }

    state.value = state.value.copy(
        goNext = {
            if (state.value.currentScreen < state.value.numScreens - 1) {
                state.value = state.value.copy(currentScreen = state.value.currentScreen + 1)
            }
        },
        goBack = {
            if (state.value.currentScreen > 0) {
                state.value = state.value.copy(currentScreen = state.value.currentScreen - 1)
            }
        },
        goTo = {destination ->
            if (state.value.currentScreen != destination) {
                state.value = state.value.copy(currentScreen = destination)
            }
        }
    )

    return state
}

@Composable
fun Onboarding(
    state: MutableState<OnboardingState>,
    vararg screens: @Composable (OnboardingState) -> Unit
) {
    screens[state.value.currentScreen](state.value)
}