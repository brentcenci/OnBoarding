package com.example.onboarding

import android.graphics.Color.WHITE
import android.graphics.Color.rgb
import android.graphics.drawable.shapes.Shape
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.ui.theme.OnBoardingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnBoardingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    /*val indicatorState = rememberIndicatorState(total = 4)

                    OnBoardingScreen(
                        headerImage = painterResource(id = R.drawable.image1),
                        title = "Life is short and the world is wide",
                        subtitle = "At Friends tours and travel, " +
                                "we customize reliable and trustworthy educational tours " +
                                "to destinations all over the world",
                        buttonText = "Get Started",
                        indicator = indicatorState
                    )*/
                    val state = rememberOnboardingState(numScreens = 3)
                    Onboarding(
                        state = state, {
                            TestScreen(
                                headerImage = painterResource(id = R.drawable.image1),
                                title = "Life is short and the world is wide",
                                subtitle = "At Friends tours and travel, " +
                                        "we customize reliable and trustworthy educational tours " +
                                        "to destinations all over the world",
                                buttonText = "Get Started",
                                onboardingState = it
                            )
                        },
                        {
                            TestScreen(
                                headerImage = painterResource(id = R.drawable.image2),
                                title = "It's a big world out there go explore",
                                subtitle = "To get the best of your adventure you just need to leave and go where you like. We are waiting for you!",
                                buttonText = "Next",
                                onboardingState = it
                            )
                        },
                        {
                            TestScreen(
                                headerImage = painterResource(id = R.drawable.image3),
                                title = "People don't take trips, trips take people",
                                subtitle = "This title is kind of creepy. What do they mean, trips take people? Like casualties? I don't want to be a casualty!",
                                buttonText = "Next",
                                onboardingState = it
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenIndicator(modifier: Modifier = Modifier, state: IndicatorState) {
    Row(modifier = modifier) {
        repeat(state.total) {
            val weight = if (it == state.current) 3f else 1f
            val color = if (it == state.current) Color(13,110,253,255) else Color.White
            Box(modifier = Modifier
                .padding(horizontal = 2.dp)
                .clip(RoundedCornerShape(50))
                .background(color)
                .height(8.dp)
                .weight(weight)
                .clickable {
                    state.current = it
                    println(state.current)
                    println(state.total)
                }
            )
        }
    }
}

class IndicatorState(
    var current: Int = 0,
    val total: Int = 1
) {
    fun goForward() {
        if (current<total-1) current++
    }
    fun goBack() {
        if (current>0) current--
    }
}

@Composable
fun rememberIndicatorState(current: Int = 0, total: Int = 1): IndicatorState {
    return remember { mutableStateOf(IndicatorState(current, total)) }.value
}

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    headerImage: Painter,
    title: String,
    subtitle: String,
    buttonText: String,
    indicator: IndicatorState
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(22, 24, 31, 255)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            headerImage,
            contentDescription = "Header",
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)),
            //.border(1.dp, Color.Black)
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, lineHeight = 36.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = subtitle, color = Color(112,112,124,255), fontSize = 15.sp, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(20.dp))
            }

            ScreenIndicator(state = indicator, modifier = Modifier
                .fillMaxWidth(0.3f)
                .align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(13,110,253,255), contentColor = Color.White),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text(text = buttonText, fontSize = 18.sp)
            }
        }
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun OnboardingIndicator(modifier: Modifier = Modifier, state: OnboardingState) {
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

@Composable
fun TestScreen(
    modifier: Modifier = Modifier,
    headerImage: Painter,
    title: String,
    subtitle: String,
    buttonText: String,
    onboardingState: OnboardingState
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(22, 24, 31, 255)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            headerImage,
            contentDescription = "Header",
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center, lineHeight = 36.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = subtitle, color = Color(112,112,124,255), fontSize = 15.sp, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(20.dp))
            }

            OnboardingIndicator(state = onboardingState, modifier = Modifier
                .fillMaxWidth(0.3f)
                .align(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { onboardingState.goNext() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(13,110,253,255), contentColor = Color.White),
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Text(text = buttonText, fontSize = 18.sp)
            }
        }
    }
}