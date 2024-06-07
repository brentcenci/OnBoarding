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
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.ui.screens.FirstStyle
import com.example.onboarding.ui.screens.FirstStyleOnboardingScreen
import com.example.onboarding.ui.screens.SecondStyleOnboardingScreen
import com.example.onboarding.ui.theme.OnBoardingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnBoardingTheme {
                /*val stateOne = rememberOnboardingState(numScreens = 3)
                Onboarding(
                    state = stateOne, {
                        FirstStyleOnboardingScreen(
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
                        FirstStyleOnboardingScreen(
                            headerImage = painterResource(id = R.drawable.image2),
                            title = "It's a big world out there go explore",
                            subtitle = "To get the best of your adventure you " +
                                    "just need to leave and go where you like. " +
                                    "We are waiting for you!",
                            buttonText = "Next",
                            onboardingState = it
                        )
                    },
                    {
                        FirstStyleOnboardingScreen(
                            headerImage = painterResource(id = R.drawable.image3),
                            title = "People don't take trips, trips take people",
                            subtitle = "This title is kind of creepy. " +
                                    "What do they mean, trips take people? " +
                                    "Like casualties? I don't want to be a casualty!",
                            buttonText = "Next",
                            onboardingState = it
                        )
                    }
                )*/
                val stateTwo = rememberOnboardingState(numScreens = 3)
                Onboarding(
                    state = stateTwo, {
                        SecondStyleOnboardingScreen(
                            mainImage = painterResource(id = R.drawable.person1),
                            title = "Enter your details",
                            subtitle = "Help us get to know you by answering our general questions.",
                            buttonText = "Get Started",
                            onboardingState = it
                        )
                    },
                    {
                        SecondStyleOnboardingScreen(
                            mainImage = painterResource(id = R.drawable.person2),
                            title = "Connect to others",
                            subtitle = "Using your details, we will help you to connect to another user.",
                            buttonText = "Okay",
                            onboardingState = it
                        )
                    },
                    {
                        SecondStyleOnboardingScreen(
                            mainImage = painterResource(id = R.drawable.person3),
                            title = "Support is here",
                            subtitle = "If you're not feeling it, connect instead to someone else!",
                            buttonText = "Let's Go",
                            onboardingState = it
                        )
                    }
                )

            }
        }
    }
}