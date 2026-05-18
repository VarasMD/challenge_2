package com.example.challenge2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.components.AppBottomBar
import com.example.challenge2.ui.components.CentralFAB
import com.example.challenge2.ui.theme.BackgroundBeige
import com.example.challenge2.ui.theme.Challenge2Theme
import com.example.challenge2.ui.theme.SelectedItemBg
import com.example.challenge2.ui.theme.TextDark
import kotlinx.coroutines.launch

@Composable
fun TitleScreen(onNavigate: (String) -> Unit = {}) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = BackgroundBeige,
                drawerShape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp),
                modifier = Modifier.width(320.dp)
            ) {
                DrawerContent(
                    onItemClick = { route ->
                        scope.launch { drawerState.close() }
                        onNavigate(route)
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = { 
                TitleTopBar(
                    onMenuClick = {
                        scope.launch { drawerState.open() }
                    },
                    onProfileClick = { onNavigate("profile") }
                ) 
            },
            bottomBar = { AppBottomBar(currentRoute = "title", onNavigate = onNavigate) },
            floatingActionButton = { CentralFAB { /* TODO */ } },
            floatingActionButtonPosition = FabPosition.Center,
        ) { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleTopBar(onMenuClick: () -> Unit, onProfileClick: () -> Unit) {
    CenterAlignedTopAppBar(
        modifier = Modifier.height(64.dp),
        title = {
            Text(
                "TITLE",
                fontWeight = FontWeight.Bold,
                color = TextDark,
                letterSpacing = 2.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = TextDark)
            }
        },
        actions = {
            IconButton(onClick = onProfileClick) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Profile", tint = TextDark)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun DrawerContent(onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(24.dp)
    ) {
        Text(
            text = "Title",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TextDark,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        
        Text(
            text = "Section Header",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextDark.copy(alpha = 0.7f),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        DrawerItem(
            icon = Icons.AutoMirrored.Filled.List,
            label = "Shop list",
            isSelected = true,
            onClick = { onItemClick("title") }
        )
        
        DrawerItem(
            icon = Icons.Default.Favorite,
            label = "Favourites",
            isSelected = false,
            badge = "3",
            onClick = { /* TODO */ }
        )
        
        DrawerItem(
            icon = Icons.Default.Person,
            label = "Profile",
            isSelected = false,
            onClick = { onItemClick("profile") }
        )
        
        DrawerItem(
            icon = Icons.Default.Settings,
            label = "Settings",
            isSelected = false,
            onClick = { /* TODO */ }
        )
    }
}

@Composable
fun DrawerItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    badge: String? = null,
    onClick: () -> Unit = {}
) {
    Surface(
        onClick = onClick,
        color = if (isSelected) SelectedItemBg else Color.Transparent,
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = TextDark,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = label,
                fontSize = 16.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = TextDark,
                modifier = Modifier.weight(1f)
            )
            if (badge != null) {
                Text(
                    text = badge,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            }
        }
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
        TitleScreen()
    }
}
