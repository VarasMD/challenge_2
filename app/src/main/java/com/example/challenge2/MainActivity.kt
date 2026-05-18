package com.example.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.challenge2.ui.screen.ProfileScreen
import com.example.challenge2.ui.screen.SettingsScreen
import com.example.challenge2.ui.screen.TitleScreen
import com.example.challenge2.ui.theme.Challenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge2Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "title") {
        composable("title") {
            TitleScreen(
                onNavigate = { route ->
                    navController.navigate(route)
                }
            )
        }
        composable("profile") {
            ProfileScreen(
                onBack = { navController.popBackStack() },
                onNavigate = { route ->
                    if (route == "title") {
                        navController.popBackStack("title", inclusive = false)
                    } else {
                        navController.navigate(route)
                    }
                }
            )
        }
        composable("settings") {
            SettingsScreen(
                onMenuClick = { /* Drawer is usually on TitleScreen, but if needed we can handle here */ },
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo("title") { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
