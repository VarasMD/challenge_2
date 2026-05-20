package com.example.challenge2.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.theme.SelectedItemBg
import com.example.challenge2.ui.theme.TextDark

@Composable
fun DrawerContent(currentRoute: String, onItemClick: (String) -> Unit) {
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
            isSelected = currentRoute == "shop_list",
            onClick = { onItemClick("shop_list") }
        )
        
        DrawerItem(
            icon = Icons.Default.Favorite,
            label = "Favourites",
            isSelected = currentRoute == "favourite",
            badge = "3",
            onClick = { onItemClick("favourite") }
        )
        
        DrawerItem(
            icon = Icons.Default.Person,
            label = "Profile",
            isSelected = currentRoute == "profile",
            onClick = { onItemClick("profile") }
        )
        
        DrawerItem(
            icon = Icons.Default.Settings,
            label = "Settings",
            isSelected = currentRoute == "settings",
            onClick = { onItemClick("settings") }
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
