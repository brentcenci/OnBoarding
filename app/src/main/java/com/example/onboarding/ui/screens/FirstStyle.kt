package com.example.onboarding.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onboarding.Onboarding
import com.example.onboarding.OnboardingState
import com.example.onboarding.R
import com.example.onboarding.rememberOnboardingState
import com.example.onboarding.ui.indicators.FirstIndicator

@Composable
fun FirstStyle(modifier: Modifier = Modifier) {
    val state = rememberOnboardingState(numScreens = 3)
    Onboarding(
        state = state, {
            FirstStyleOnboardingScreen(
                headerImage = painterResource(id = R.drawable.image1),
                title = "Discover a new way to live your life",
                subtitle = "Unlock exclusive travel experiences tailored just for you by Travel Company Name, making each journey unforgettable and unique.",
                buttonText = "Get Started",
                onboardingState = it
            )
        },
        {
            FirstStyleOnboardingScreen(
                headerImage = painterResource(id = R.drawable.image2),
                title = "Challenge yourself with exciting adventures",
                subtitle = "Push your limits with thrilling adventures, designed to inspire and invigorate your spirit of exploration.",
                buttonText = "Next",
                onboardingState = it
            )
        },
        {
            FirstStyleOnboardingScreen(
                headerImage = painterResource(id = R.drawable.image3),
                title = "Experience more of what life has to offer",
                subtitle = "Discover a world of endless possibilities, offering enriching experiences that broaden your horizons and enhance your life.",
                buttonText = "Next",
                onboardingState = it
            )
        }
    )
}

@Composable
fun FirstStyleOnboardingScreen(
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

            FirstIndicator(state = onboardingState, modifier = Modifier
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