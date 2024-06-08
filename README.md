
# Onboarding for Compose

Onboarding is a small set of functions for Android with Compose that provides state management to easily establish Onboarding features typically seen in large service applications.



## Demo Application

Clone this repo for three different examples of how to use this feature in your applications.

![App Screenshot](https://i.imgur.com/L6yJtpV.png)
## Usage/Examples

### Using it in your project

Create an `OnboardingState` using the `rememberOnboardingState()` function, and pass in the number of screens you will be using.
```kotlin
val state = rememberOnboardingState(numScreens = 3)
```

Add the `Onboarding()` composable into your project and pass in the state you just created,  as well as each of the screens you've set aside for Onboarding.

Make sure you pass the state to each screen too so that they can read and manipulate the state - such as when you need to observe the current screen such as in an indicator or for when you need to go to the next screen on a button press.

```kotlin
    Onboarding(
        state = state, 
        {
            Screen1(onboardingState = it)
        },
        {
            Screen2(onboardingState = it)
        },
        {
            Screen3(onboardingState = it)
        }
    )
```

### Properties and Functions
#### For each state, you have the following properties:

#### `currentScreen`
- **Type:** `Int`
- **Description:** Holds the current screen for the state as a 0-based index

#### `numScreens`
- **Type:** `Int`
- **Description:** The total number of screens included in this OnboardingState. Set up when the state is first created with `rememberOnboardingState()`

#### And the following functions:
#### `goNext()`
- **Description:** Increments the `currentScreen` value if there are more screens available.

#### `goBack()`
- **Description:** Decrements the `currentScreen` value if there are more screens available.

#### `goTo(screen: Int)`
- **Parameters:** `screen` - The index of the desired screen to select and view
- **Description:** Sets the `currentScreen` value to be that of the passed in value, if it is not that already.

### Example Use
An example of the use of the above properties and functions from my demo project is how I set up my indicator to work for the first set of example Onboarding screens:

```kotlin
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
```
As shown here, the Indicator takes in the OnboardingState value and reads it to check if the current indicator `Box` represents the current screen or not. Furthermore, each `Box` is given the `clickable` modifier to allow instant navigation to the selected Onboarding screen.

Further examples are available in the demo application as above.
