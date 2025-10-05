package com.trihashstudio.noortasbih.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun ProgressScreen(
    navController: NavHostController, viewModel: DhikrViewModel
) {

    val totalDhikrCount = viewModel.totalDhikrCount
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Your Progress",
            style = MaterialTheme.typography.displayMedium,
            color = Color(0xFFCF9857),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(50.dp))
        DhikrProgressAnimate(progress = totalDhikrCount, max = 500)
        Spacer(Modifier.height(30.dp))
        Text(
            text = "Most Repeated Dhikr",
            color = Color(0xFF1E4447),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Subhanallah",
                color = Color.Gray,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "${viewModel.subhanCount} times", style = TextStyle(
                    color = Color.LightGray, fontWeight = FontWeight.Normal, fontSize = 20.sp
                )
            )
        }
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Alhamdulillah",
                color = Color.Gray,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "${viewModel.alhamdCount} times", style = TextStyle(
                    color = Color.LightGray, fontWeight = FontWeight.Normal, fontSize = 20.sp
                )
            )
        }
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Allah u Akbar",
                color = Color.Gray,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "${viewModel.allahCount} times", style = TextStyle(
                    color = Color.LightGray, fontWeight = FontWeight.Normal, fontSize = 20.sp
                )
            )
        }
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "La ilaha ilallah",
                color = Color.Gray,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "${viewModel.laIlallahCount} times", style = TextStyle(
                    color = Color.LightGray, fontWeight = FontWeight.Normal, fontSize = 20.sp
                )
            )
        }
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Astaghfirullah",
                color = Color.Gray,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "${viewModel.astaghCount} times", style = TextStyle(
                    color = Color.LightGray, fontWeight = FontWeight.Normal, fontSize = 20.sp
                )
            )
        }
        Spacer(Modifier.height(30.dp))
//        Text(
//            text = "Summary",
//            color = Color(0xFF1E4447),
//            style = MaterialTheme.typography.displaySmall
//        )
//        Spacer(Modifier.height(30.dp))
//        Text(
//            "5 Active Days This Week", color = Color.Black,style = MaterialTheme.typography.headlineMedium
//        )
//        Spacer(Modifier.height(20.dp))
//        Text("Daily Average", color = Color.Black,style = MaterialTheme.typography.headlineMedium)

    }
}
