package com.trihashstudio.noortasbih.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun DhikrScreen(navController: NavHostController,viewModel: DhikrViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp)
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Lists Of Dhikr",
            color = Color(0xFFCF9857),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(Modifier.height(50.dp))
        Text(
            text = "Preloaded Dhikr", style = MaterialTheme.typography.displaySmall,
            color = Color(0xFF1E4447),
        )
        Spacer(Modifier.height(20.dp))
        DhikrRow(name = "After Salah"){
            viewModel.setDhikr("After Salah")
            navController.navigate("home")
            viewModel.reset()
        }
    }

}

@Composable
private fun DhikrRow(
    name: String,
    onButtonClick: () -> Unit
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color(0xFFCF9857),
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text(text = name, color = Color.Gray, style = MaterialTheme.typography.headlineMedium)
        }
        Button(
            onClick = onButtonClick, colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,   // background color
                contentColor = Color.White            // text/icon color
            )
        ) {
            Text(text = "Start")
        }
    }
}