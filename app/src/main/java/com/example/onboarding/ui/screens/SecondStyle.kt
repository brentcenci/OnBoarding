package com.example.onboarding.ui.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onboarding.Onboarding
import com.example.onboarding.OnboardingState
import com.example.onboarding.R
import com.example.onboarding.rememberOnboardingState
import com.example.onboarding.ui.indicators.SecondIndicator

@Composable
fun SecondStyle(modifier: Modifier = Modifier, navController: NavController) {
    //Images sourced from: @tegarsip103 on Vecteezy.com
    val state = rememberOnboardingState(numScreens = 3)
    Onboarding(
        state = state, {
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

@Composable
fun SecondStyleOnboardingScreen(
    modifier: Modifier = Modifier,
    mainImage: Painter,
    title: String,
    subtitle: String,
    buttonText: String,
    onboardingState: OnboardingState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(mainImage, "Image from Vecteezy.com", modifier = Modifier.size(300.dp))
        Spacer(modifier = Modifier.height(20.dp))
        SecondIndicator(state = onboardingState, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = title.uppercase(), color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = subtitle, color = Color.Gray, fontWeight = FontWeight.Normal, fontSize = 14.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { onboardingState.goNext() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(245, 69, 83,255)),
            modifier = Modifier.border(2.dp, Color(245, 69, 83,255), shape = RoundedCornerShape(50))
        ) {
            Text(buttonText)
        }
    }
}