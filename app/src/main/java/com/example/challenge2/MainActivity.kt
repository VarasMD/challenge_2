package com.example.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.challenge2.ui.components.DrawerContent
import com.example.challenge2.ui.screen.FavouriteScreen
import com.example.challenge2.ui.screen.ProfileScreen
import com.example.challenge2.ui.screen.SettingsScreen
import com.example.challenge2.ui.screen.ShopListScreen
import com.example.challenge2.ui.screen.TitleScreen
import com.example.challenge2.ui.theme.BackgroundBeige
import com.example.challenge2.ui.theme.Challenge2Theme
import kotlinx.coroutines.launch

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
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "title"

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = BackgroundBeige,
                drawerShape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                modifier = Modifier.width(320.dp)
            ) {
                DrawerContent(
                    currentRoute = currentRoute,
                    onItemClick = { route ->
                        scope.launch { drawerState.close() }
                        if (route != currentRoute) {
                            navController.navigate(route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "title") {
            composable("title") {
                TitleScreen(
                    onMenuClick = { scope.launch { drawerState.open() } },
                    onNavigate = { route ->
                        navController.navigate(route)
                    }
                )
            }
            composable("shop_list") {
                ShopListScreen(
                    onMenuClick = { scope.launch { drawerState.open() } },
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
                    onMenuClick = { scope.launch { drawerState.open() } },
                    onNavigate = { route ->
                        navController.navigate(route)
                    }
                )
            }
            composable("favourite") {
                FavouriteScreen(
                    onMenuClick = { scope.launch { drawerState.open() } },
                    onNavigate = { route ->
                        navController.navigate(route)
                    }
                )
            }
        }
    }
}
