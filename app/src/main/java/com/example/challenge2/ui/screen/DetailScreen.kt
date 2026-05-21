package com.example.challenge2.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.components.AppBottomBar
import com.example.challenge2.ui.components.TopBarComponent
import com.example.challenge2.ui.theme.BackgroundBeige
import com.example.challenge2.ui.theme.Challenge2Theme
import com.example.challenge2.ui.theme.PrimaryBrown
import com.example.challenge2.ui.theme.TextDark

@Composable
fun DetailScreen(onMenuClick: () -> Unit, onBack: () -> Unit, onNavigate: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopBarComponent(
                title = "Leather boots",
                navigationIcon = Icons.Default.Menu,
                onNavigationClick = onMenuClick,
                onActionClick = { onNavigate("profile") }
            )
        },
        bottomBar = { AppBottomBar(currentRoute = "title", onNavigate = onNavigate) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(BackgroundBeige)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            
            Text(
                text = "Select size",
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = TextDark
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = "Input",
                onValueChange = {},
                label = { Text("Label") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                },
                shape = RoundedCornerShape(8.dp),
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = PrimaryBrown
                )
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = "Count of producy",
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = TextDark
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedTextField(
                value = "Input",
                onValueChange = {},
                label = { Text("Label") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = PrimaryBrown
                )
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 64.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier
                        .width(130.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryBrown),
                    border = BorderStroke(1.dp, PrimaryBrown)
                ) {
                    Text("Back", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                }
                
                Button(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .width(120.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBrown)
                ) {
                    Text("Buy", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Challenge2Theme {
        DetailScreen(onMenuClick = {}, onBack = {}, onNavigate = {})
    }
}
