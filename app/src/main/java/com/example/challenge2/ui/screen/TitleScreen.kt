package com.example.challenge2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.theme.Challenge2Theme

// Colores constantes para el diseño
private val PrimaryBrown = Color(0xFF8D3B1E)
private val TextDark = Color(0xFF423430)
private val BackgroundBeige = Color(0xFFF5EBEB)

@Composable
fun TitleScreen() {
    Scaffold(
        topBar = { TitleTopBar() },
        bottomBar = { TitleBottomBar() },
        floatingActionButton = { CentralFAB() },
        floatingActionButtonPosition = FabPosition.Center,
    ) { innerPadding ->
        MainContent(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "TITLE",
                fontWeight = FontWeight.Bold,
                color = TextDark,
                letterSpacing = 2.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = TextDark)
            }
        },
        actions = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Profile", tint = TextDark)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun TitleBottomBar() {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(Icons.Default.Home, "Product", isSelected = true)
            BottomNavItem(Icons.Default.Search, "Search", isSelected = false)
            
            // Espacio central para el FAB
            Box(modifier = Modifier.size(60.dp))
            
            BottomNavItem(Icons.Default.ShoppingCart, "Cart", isSelected = false)
            BottomNavItem(Icons.Default.Person, "Profile", isSelected = false)
        }
    }
}

@Composable
fun BottomNavItem(icon: ImageVector, label: String, isSelected: Boolean) {
    val color = if (isSelected) PrimaryBrown else Color.Gray
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Icon(icon, contentDescription = label, tint = color, modifier = Modifier.size(26.dp))
        Text(
            text = label, 
            fontSize = 11.sp, 
            color = color, 
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
fun CentralFAB() {
    FloatingActionButton(
        onClick = { /* TODO */ },
        shape = CircleShape,
        containerColor = PrimaryBrown,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(4.dp),
        modifier = Modifier
            .size(72.dp)
            .offset(y = 50.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Home, 
            contentDescription = "Main Shop",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundBeige)
    )
}

@Preview(showBackground = true)
@Composable
fun TitleScreenPreview() {
    Challenge2Theme {
        TitleScreen()
    }
}
