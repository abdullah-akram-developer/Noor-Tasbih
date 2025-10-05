package com.trihashstudio.noortasbih.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import com.trihashstudio.noortasbih.R
import com.trihashstudio.noortasbih.ui.theme.Background
import com.trihashstudio.noortasbih.ui.theme.NoorTasbihTheme


@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(1500) // wait for splash animation / logo

        if (PrefsManager.isOnboardingCompleted(context)) {
            // User already completed onboarding → Go to Home
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        } else {
            // First time → Show Onboarding
            navController.navigate("onboard1") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(
                WindowInsets.systemBars.asPaddingValues() // ✅ Adds top & bottom padding for system bars
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(380.dp)
        )
        Text(
            text = "Noor Tasbih", style = MaterialTheme.typography.displayLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    NoorTasbihTheme {
        SplashScreen(navController)
    }
}
