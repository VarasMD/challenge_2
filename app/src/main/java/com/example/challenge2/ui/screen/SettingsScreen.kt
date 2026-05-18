package com.example.challenge2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.components.AppBottomBar
import com.example.challenge2.ui.components.CentralFAB
import com.example.challenge2.ui.components.TopBarComponent
import com.example.challenge2.ui.theme.BackgroundBeige
import com.example.challenge2.ui.theme.Challenge2Theme
import com.example.challenge2.ui.theme.PrimaryBrown
import com.example.challenge2.ui.theme.TextDark

@Composable
fun SettingsScreen(onMenuClick: () -> Unit, onNavigate: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopBarComponent(
                title = "Settings",
                navigationIcon = Icons.Default.Menu,
                onNavigationClick = onMenuClick,
                onActionClick = { onNavigate("profile") }
            )
        },
        bottomBar = { AppBottomBar(currentRoute = "settings", onNavigate = onNavigate) },
        floatingActionButton = { CentralFAB { /* TODO */ } },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(BackgroundBeige)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Account Settings",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray.copy(alpha = 0.6f),
                modifier = Modifier.padding(vertical = 16.dp)
            )
            
            SettingsItem("Edit profile", hasChevron = true)
            SettingsItem("Change password", hasChevron = true)
            
            var pushNotifications by remember { mutableStateOf(true) }
            SettingsSwitchItem("Push notifications", pushNotifications) { pushNotifications = it }
            
            var darkMode by remember { mutableStateOf(true) }
            SettingsSwitchItem("Dark mode", darkMode) { darkMode = it }

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.3f), thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "More",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray.copy(alpha = 0.6f),
                modifier = Modifier.padding(vertical = 16.dp)
            )
            
            SettingsItem("About us", hasChevron = true)
            SettingsItem("Privacy policy", hasChevron = true)
            SettingsItem("Terms and conditions", hasChevron = false)
            
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun SettingsItem(title: String, hasChevron: Boolean, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = TextDark
        )
        if (hasChevron) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = TextDark.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun SettingsSwitchItem(title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = TextDark
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = PrimaryBrown,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color.LightGray
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    Challenge2Theme {
        SettingsScreen(onMenuClick = {}, onNavigate = {})
    }
}
