package com.trihashstudio.noortasbih.presentation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseAuth
import com.trihashstudio.noortasbih.ui.theme.Highlight
import com.trihashstudio.noortasbih.R
import com.trihashstudio.noortasbih.ui.theme.Background

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val dhikrViewModel: DhikrViewModel = viewModel()


    // ✅ Observe current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // ✅ Define routes where bottom bar should be visible
    val bottomBarRoutes = listOf("home", "dhikr", "progress", "profile")

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomBarRoutes) {
                MyBottomNavigationBar(navController)
            }
        }) { innerPadding ->

        NavHost(
            navController = navController, startDestination = "splash", // start from splash
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("splash") { SplashScreen(navController) }
            composable("onboard1") { OnboardScreen1(navController) }
            composable("onboard2") { OnboardScreen2(navController) }
            composable("onboard3") { OnboardScreen3(navController) }
            composable("home") { HomeScreen(navController,dhikrViewModel) }
            composable("dhikr") { DhikrScreen(navController,dhikrViewModel) }
//            composable("progress") { ProgressScreen(navController, dhikrViewModel) }
//            composable("login") { LoginScreen(navController) }
//            composable("profile") { AfterLoginScreen(navController) }
            composable("progress") {
                val user = FirebaseAuth.getInstance().currentUser
                if (user != null) {
                    ProgressScreen(navController, dhikrViewModel)
                } else {
                    BeforeProgressScreen(navController)
                }
            }

            // ✅ CONDITIONAL PROFILE SCREEN
            composable("profile") {
                val user = FirebaseAuth.getInstance().currentUser
                if (user != null) {
                    AfterLoginScreen(navController)
                } else {
                    LoginScreen(navController)
                }
            }

            composable("login") { LoginScreen(navController) }
        }
    }
}

@Composable
fun MyBottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Home", "home", R.drawable.home),
        BottomNavItem("Dhikr", "dhikr", R.drawable.beads),
        BottomNavItem("Progress", "progress", R.drawable.progression),
        BottomNavItem("Profile", "profile", R.drawable.user1)

    )

    NavigationBar (containerColor = Background){
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        items.forEachIndexed { index, item ->
            val isSelected = currentDestination?.route == item.route

            NavigationBarItem(selected = isSelected, onClick = {
                navController.navigate(item.route) {
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }, icon = {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = item.iconRes),
                    contentDescription = item.label,
                    tint = if (isSelected) Highlight else Color.White // ✅ Tint based on selection
                )
            }, label = { Text(item.label) })
        }
    }
}

data class BottomNavItem(
    val label: String, val route: String, val iconRes: Int
)
