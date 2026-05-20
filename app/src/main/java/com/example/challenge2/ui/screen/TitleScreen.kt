package com.example.challenge2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.components.AppBottomBar
import com.example.challenge2.ui.components.CentralFAB
import com.example.challenge2.ui.components.TopBarComponent
import com.example.challenge2.ui.theme.BackgroundBeige
import com.example.challenge2.ui.theme.Challenge2Theme
import com.example.challenge2.ui.theme.TextDark

@Composable
fun TitleScreen(onMenuClick: () -> Unit, onNavigate: (String) -> Unit) {
    Scaffold(
        topBar = { 
            TopBarComponent(
                title = "TITLE",
                navigationIcon = Icons.Default.Menu,
                onNavigationClick = onMenuClick,
                onActionClick = { onNavigate("profile") },
                titleStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    fontSize = 20.sp
                )
            )
        },
        bottomBar = { AppBottomBar(currentRoute = "title", onNavigate = onNavigate) },
        floatingActionButton = { CentralFAB { /* Acción del FAB */ } },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        MainContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().background(BackgroundBeige))
}

@Preview(showBackground = true)
@Composable
fun TitleScreenPreview() {
    Challenge2Theme {
        TitleScreen(onMenuClick = {}, onNavigate = {})
    }
}
