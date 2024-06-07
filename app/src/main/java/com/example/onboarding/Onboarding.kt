package com.example.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

/**
 * Data class representing the Onboarding State
 *
 * @property currentScreen The current screen the user is on, starts at index 0
 * @property numScreens The total number of screens in the Onboarding sequence
 * @property goNext A function to visit the next available screen in the Onboarding sequence
 * @property goBack A function to visit the previous available screen in the Onboarding sequence
 * @property goTo A function which takes an integer parameter of the index screen to visit
 */
data class OnboardingState(
    val currentScreen: Int = 0,
    val numScreens: Int,
    val goNext: () -> Unit = { },
    val goBack: () -> Unit = { },
    val goTo: (Int) -> Unit = { }
)

/**
 * Composable function to create and hold the OnboardingState
 *
 * @param numScreens The total number of screens in the Onboarding sequence
 * @return The MutableState of type OnboardingState
 */
@Composable
fun rememberOnboardingState(numScreens: Int): MutableState<OnboardingState> {
    //Creates a state object
    val state = remember { mutableStateOf(OnboardingState(numScreens = numScreens)) }

    //Sets up goNext, goBack and goTo functions as they require references to the state they're contained within
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

/**
 * Composable function to manage Onboarding Screens
 *
 * @param state The state associated with this set of Onboarding Screens. Typically there will be one state per application.
 * @param screens A variable number of Composable functions which will act as Screens for the Onboarding sequence
 */
@Composable
fun Onboarding(
    state: MutableState<OnboardingState>,
    vararg screens: @Composable (OnboardingState) -> Unit
) {
    //Display the screen at the index of the "currentScreen" property, and pass in the state
    screens[state.value.currentScreen](state.value)
}