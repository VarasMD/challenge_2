package com.example.challenge2.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.R
import com.example.challenge2.ui.components.AppBottomBar
import com.example.challenge2.ui.components.CentralFAB
import com.example.challenge2.ui.components.TopBarComponent
import com.example.challenge2.ui.theme.BackgroundBeige
import com.example.challenge2.ui.theme.Challenge2Theme
import com.example.challenge2.ui.theme.PrimaryBrown
import com.example.challenge2.ui.theme.TextDark

@Composable
fun ShopListScreen(onMenuClick: () -> Unit, onNavigate: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopBarComponent(
                title = "Shop list",
                navigationIcon = Icons.Default.Menu,
                onNavigationClick = onMenuClick,
                onActionClick = { onNavigate("profile") }
            )
        },
        bottomBar = { AppBottomBar(currentRoute = "shop_list", onNavigate = onNavigate) },
        floatingActionButton = { CentralFAB { onNavigate("title") } },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(BackgroundBeige)
        ) {
            val shopItems = listOf(1, 2, 3)

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(shopItems) {
                    ShopItemCard(onClick = { onNavigate("detail") })
                }
                item {
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}

@Composable
fun ShopItemCard(onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.boots),
                contentDescription = "Leather boots",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )
            
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Leather boots",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
                Text(
                    text = "27,5 $",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Great warm shoes from the artificial leather. You can buy this model only in our shop",
                    fontSize = 14.sp,
                    color = TextDark.copy(alpha = 0.8f),
                    lineHeight = 20.sp
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { /* TODO */ },
                        shape = RoundedCornerShape(24.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = PrimaryBrown),
                        border = BorderStroke(1.dp, PrimaryBrown),
                        modifier = Modifier.height(44.dp)
                    ) {
                        Text("Add to favourite", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Button(
                        onClick = { /* TODO */ },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBrown),
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier.height(44.dp).width(80.dp)
                    ) {
                        Text("Buy", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopListScreenPreview() {
    Challenge2Theme {
        ShopListScreen(onMenuClick = {}, onNavigate = {})
    }
}
