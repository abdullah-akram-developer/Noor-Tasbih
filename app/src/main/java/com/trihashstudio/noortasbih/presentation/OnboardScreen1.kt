package com.trihashstudio.noortasbih.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.trihashstudio.noortasbih.R
import com.trihashstudio.noortasbih.ui.theme.Background
import com.trihashstudio.noortasbih.ui.theme.NoorTasbihTheme


@Composable
fun OnboardScreen1(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 22.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(Modifier.height(100.dp))
            Image(
                painter = painterResource(R.drawable.beed_hand),
                contentDescription = null,
                modifier = Modifier.size(300.dp)
            )
            Spacer(Modifier.height(30.dp))
            Text(text = "Digital Tasbih", style = MaterialTheme.typography.displayMedium)
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Count Your Dhikr With Ease, Anytime, Anywhere.",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                color = Color(0xFFD4B483)
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = {
                    PrefsManager.setOnboardingCompleted(context, true)
                    navController.navigate("home") {
                        popUpTo("onboard1") { inclusive = true }
                    }
                }, border = BorderStroke(1.dp, Color.Transparent)
            ) {
                Text(text = "Skip", fontSize = 18.sp)
            }
            OutlinedButton(
                onClick = { navController.navigate("onboard2") },
                border = BorderStroke(1.dp, Color.Transparent)
            ) {
                Text(text = "Next", fontSize = 18.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetinsgPreview() {
    val navController = rememberNavController()
    NoorTasbihTheme {
        OnboardScreen1(navController)
    }
}