package com.example.challenge2.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.theme.TextDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    title: String,
    navigationIcon: ImageVector,
    onNavigationClick: () -> Unit,
    onActionClick: () -> Unit = {},
    actionIcon: ImageVector = Icons.Default.AccountCircle,
    titleStyle: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.height(64.dp),
        title = {
            Text(
                text = title,
                style = titleStyle,
                color = TextDark
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = "Navigation",
                    tint = TextDark
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = "Action",
                    tint = TextDark,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        )
    )
}
