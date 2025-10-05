package com.trihashstudio.noortasbih.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.trihashstudio.noortasbih.R
import com.trihashstudio.noortasbih.ui.theme.NoorTasbihTheme
import com.trihashstudio.noortasbih.ui.theme.gradientBrush

@SuppressLint("ServiceCast")
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: DhikrViewModel
) {
    val dhikrName by viewModel.selectedDhikr
    val dhikrCount = viewModel.dhikrCount

    // Base options (normal wheel)
    val baseOptions = listOf(
        "Dhikr",
        "SubhanAllah",
        "Alhamdulillah",
        "Allahu Akbar",
        "La ilaha illallah",
        "Astaghfirullah"
    )

    // If special dhikr selected, include it at the front of the wheel
    val dhikrOptions = if (
        dhikrName == "After Salah"
    ) {
        listOf(dhikrName) + baseOptions
    } else {
        baseOptions
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title and reset button
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                text = "My Dhikr",
                style = MaterialTheme.typography.displayMedium,
                color = Color(0xFFCF9857)
            )

            IconButton(
                onClick = { viewModel.reset() },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Dhikr",
                    tint = Color(0xFFCF9857),
                    modifier = Modifier.size(35.dp)
                )
            }
        }

        Spacer(Modifier.height(50.dp))
        Text(text = viewModel.currentPhase, color = Color.Gray)
        Spacer(Modifier.height(30.dp))

        // Wheel picker (always visible, with special dhikr injected if needed)
        DhikrWheelPicker(
            dhikrOptions = dhikrOptions,
            viewModel = viewModel
        )

// 👇 Separate scroll indicator below picker
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Scroll down",
            tint = Color.Gray.copy(alpha = 0.6f),
            modifier = Modifier
                .padding(top = 0.dp, bottom = 8.dp) // spacing
                .size(28.dp) // adjust size as you like
        )

        // Counter
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$dhikrCount",
                style = TextStyle(fontSize = 80.sp, color = Color(0xFFCF9857))
            )

            if (dhikrName == "After Salah") {
                when (viewModel.currentPhase) {
                    "SubhanAllah", "Alhamdulillah" -> {
                        Text(
                            text = "/33",
                            style = TextStyle(fontSize = 25.sp, color = Color(0xFFCF9857))
                        )
                    }
                    "Allahu Akbar" -> {
                        Text(
                            text = "/34",
                            style = TextStyle(fontSize = 25.sp, color = Color(0xFFCF9857))
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(30.dp))

        // Tasbih Button
        Box(contentAlignment = Alignment.Center) {
            // styles (lowest background)
//            Image(
//                painter = painterResource(R.drawable.styles),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(350.dp)
//                    .zIndex(0f)
//            )
//
//            // golden dots (above styles, below wood)
//            Image(
//                modifier = Modifier
//                    .offset(y = (-98).dp, x = (13).dp)
//                    .size(80.dp)
//                    .zIndex(1f),
//                painter = painterResource(R.drawable.gold_dot),
//                contentDescription = null
//            )
//            Image(
//                modifier = Modifier
//                    .offset(y = (-89).dp, x = (-43).dp)
//                    .size(80.dp)
//                    .zIndex(1f),
//                painter = painterResource(R.drawable.gold_dot),
//                contentDescription = null
//            )
//            Image(
//                modifier = Modifier
//                    .offset(y = (-50).dp, x = (-85).dp)
//                    .size(80.dp)
//                    .zIndex(1f),
//                painter = painterResource(R.drawable.gold_dot),
//                contentDescription = null
//            )
//
//            // wood (above dots)
//            Image(
//                painter = painterResource(R.drawable.wood),
//                contentDescription = null,
//                modifier = Modifier
//                    .size(278.dp)
//                    .zIndex(2f)
//            )
            Image(
                painter = painterResource(R.drawable.screen_wood),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
                    .zIndex(2f)
            )
            // center button (always top)
            Box(
                modifier = Modifier
                    .offset(y = 7.dp, x = -1.dp)
                    .zIndex(3f)
            ) {
                val context = LocalContext.current

                Button(
                    modifier = Modifier
                        .size(80.dp)
                        .background(brush = gradientBrush, shape = CircleShape),
                    onClick = {
                        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                            val vibManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                            vibManager.defaultVibrator
                        } else {
                            @Suppress("DEPRECATION")
                            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                        }

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            vibrator.vibrate(
                                VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE)
                            )
                        } else {
                            @Suppress("DEPRECATION")
                            vibrator.vibrate(50)
                        }
                        when (dhikrName) {
                            "Morning Dhikr" -> viewModel.afterSalahIncrement()
                            "Evening Dhikr" -> viewModel.afterSalahIncrement()
                            "After Salah" -> viewModel.afterSalahIncrement()
                            "SubhanAllah" -> viewModel.subhanallahIncrement()
                            "Alhamdulillah" -> viewModel.alhamdulilahIncrement()
                            "Allahu Akbar" -> viewModel.allahuakbarIncrement()
                            "La ilaha illallah" -> viewModel.laIlallahIncrement()
                            "Astaghfirullah" -> viewModel.astaghfirulahIncrement()
                            else -> viewModel.increment()
                        }
                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFFCF9857),
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
        }

    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun DhikrWheelPicker(
    dhikrOptions: List<String>,
    viewModel: DhikrViewModel
) {
    // pick initial page from viewModel selection (should be in the list when wheel is shown)
    val initialPage = dhikrOptions.indexOf(viewModel.selectedDhikr.value).coerceAtLeast(0)
    val pagerState = rememberPagerState(initialPage = initialPage)

    VerticalPager(
        count = dhikrOptions.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp) // wheel height
    ) { page ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = dhikrOptions[page],
                style = MaterialTheme.typography.displayLarge,
                color = Color(0xFF1E4447)
            )
        }
    }

    // Update viewModel when the wheel page changes
    LaunchedEffect(pagerState.currentPage) {
        val selected = dhikrOptions[pagerState.currentPage]
        // only update if it's different (avoids unnecessary writes)
        if (viewModel.selectedDhikr.value != selected) {
            viewModel.setDhikr(selected)
            viewModel.reset()
        }
    }
}


//@SuppressLint("ViewModelConstructorInComposable")
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    val navController = rememberNavController()
//    val fakeViewModel = DhikrViewModel() // ⚠️ if it has no params / default constructor
//
//    HomeScreen(
//        navController = navController,
//        viewModel = fakeViewModel
//    )
//}
