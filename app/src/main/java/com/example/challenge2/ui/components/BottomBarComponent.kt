package com.example.challenge2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.theme.PrimaryBrown

@Composable
fun AppBottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = Icons.Default.Home,
                label = "Product",
                isSelected = currentRoute == "title",
                onClick = { onNavigate("title") }
            )
            BottomNavItem(
                icon = Icons.Default.Search,
                label = "Search",
                isSelected = currentRoute == "search",
                onClick = { /* TODO */ }
            )
            
            // Espacio para el FAB central
            Box(modifier = Modifier.size(60.dp))
            
            BottomNavItem(
                icon = Icons.Default.ShoppingCart,
                label = "Cart",
                isSelected = currentRoute == "cart",
                onClick = { /* TODO */ }
            )
            BottomNavItem(
                icon = Icons.Default.Person,
                label = "Profile",
                isSelected = currentRoute == "profile",
                onClick = { onNavigate("profile") }
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val color = if (isSelected) PrimaryBrown else Color.Gray
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = color,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            color = color,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
fun CentralFAB(onClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = onClick,
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
