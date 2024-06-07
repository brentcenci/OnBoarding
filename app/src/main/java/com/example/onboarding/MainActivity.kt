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
                    OnBoardingScreen(
                        headerImage = painterResource(id = R.drawable.image1),
                        title = "Life is short and the world is wide",
                        subtitle = "At Friends tours and travel, " +
                                "we customize reliable and trustworthy educational tours " +
                                "to destinations all over the world",
                        buttonText = "Get Started")
                }
            }
        }
    }
}

@Composable
fun ScreenIndicator(modifier: Modifier = Modifier, current: Int, total: Int) {
    Row(modifier = modifier) {
        repeat(total) {
            val weight = if (it == current) 3f else 1f
            val color = if (it == current) Color(13,110,253,255) else Color.White
            Box(modifier = Modifier
                .padding(horizontal = 2.dp)
                .clip(RoundedCornerShape(50))
                .background(color)
                .height(8.dp)
                .weight(weight))
        }
    }
}

class IndicatorState(
    private var current: Int = 0,
    private val total: Int = 1
) {
    fun goForward() {
        if (current<total-1) current++
    }
    fun goBack() {
        if (current>0) current--
    }
}

@Composable
fun rememberIndicatorState(start: Int = 0, total: Int = 1): IndicatorState {
    return remember { mutableStateOf(IndicatorState(start, total)) }.value
}

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    headerImage: Painter,
    title: String,
    subtitle: String,
    buttonText: String,
    indicator: @Composable (Modifier, Int, Int) -> Unit = { thismodifier, current, total ->
        //Text("Current: $current out of $total", color = Color.White )
        ScreenIndicator(modifier = thismodifier, current = current, total = total)
    }
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

            indicator(
                Modifier
                    .fillMaxWidth(0.2f)
                    .align(Alignment.CenterHorizontally),1, 3)

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

@Composable
fun OnBoardingScreens(modifier: Modifier = Modifier, vararg screens: @Composable () -> Unit) {
    val indicatorState = rememberIndicatorState()
}