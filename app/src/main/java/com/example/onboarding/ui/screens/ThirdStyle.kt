package com.example.onboarding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onboarding.Onboarding
import com.example.onboarding.OnboardingState
import com.example.onboarding.R
import com.example.onboarding.rememberOnboardingState
import com.example.onboarding.ui.indicators.SecondIndicator
import com.example.onboarding.ui.indicators.ThirdIndicator

@Composable
fun ThirdStyle(modifier: Modifier = Modifier, navController: NavController) {
    val state = rememberOnboardingState(numScreens = 3)
    Onboarding(
        state = state, {
            ThirdStyleOnboardingScreen(
                mainImage = painterResource(id = R.drawable.third1),
                title = "Simpler. Better.",
                subtitle = "We make it easier to buy products online. Place an order with us for quick and seamless service.",
                buttonText = "Get Started",
                onboardingState = it
            )
        },
        {
            ThirdStyleOnboardingScreen(
                mainImage = painterResource(id = R.drawable.third2),
                title = "Sourcing.",
                subtitle = "Our effective staff will find the best source for your products to provide you with the earliest arrival.",
                buttonText = "Okay",
                onboardingState = it
            )
        },
        {
            ThirdStyleOnboardingScreen(
                mainImage = painterResource(id = R.drawable.third3),
                title = "Direct to you.",
                subtitle = "We do all the heavy lifting, so you can sit back and watch as your product arrives at your doorstep.",
                buttonText = "Let's Go",
                onboardingState = it
            )
        }
    )
}

@Composable
fun ThirdStyleOnboardingScreen(
    modifier: Modifier = Modifier,
    mainImage: Painter,
    title: String,
    subtitle: String,
    buttonText: String,
    onboardingState: OnboardingState
) {
    val bgImage = painterResource(id = R.drawable.grid)
    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(bgImage, contentScale = ContentScale.FillHeight, alpha = 0.15f)
            .padding(20.dp),
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(mainImage, "", modifier = Modifier.size(400.dp))

        Spacer(modifier = Modifier.weight(1f))
        Text(text = title, color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = subtitle, color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 14.sp, textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(50.dp))
        ThirdIndicator(state = onboardingState, /*modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black)*/)
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            if (onboardingState.currentScreen!= 0) {
                Button(
                    onClick = { onboardingState.goBack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.LightGray),
                    modifier = Modifier.border(2.dp, Color.LightGray, shape = RoundedCornerShape(50))
                ) {
                    Text("Back")
                }
            }
            Spacer(Modifier.weight(1f))
            Button(
                onClick = { onboardingState.goNext() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(10, 10, 10), contentColor = Color.White),
                modifier = Modifier
                    .border(2.dp, Color(10, 10, 10), shape = RoundedCornerShape(50))
                    .background(Color(10, 10, 10), RoundedCornerShape(50)),
            ) {
                Text(buttonText)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}