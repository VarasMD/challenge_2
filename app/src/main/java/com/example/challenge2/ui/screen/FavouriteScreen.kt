package com.example.challenge2.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
fun FavouriteScreen(onMenuClick: () -> Unit, onNavigate: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopBarComponent(
                title = "Favourites",
                navigationIcon = Icons.Default.Menu,
                onNavigationClick = onMenuClick,
                onActionClick = { onNavigate("profile") }
            )
        },
        bottomBar = { 
            // Según la imagen, "Product" sigue marcado como seleccionado en la barra inferior
            AppBottomBar(currentRoute = "title", onNavigate = onNavigate) 
        },
        floatingActionButton = { CentralFAB { onNavigate("title") } },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(BackgroundBeige)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val favouriteItems = listOf("Item 1", "Item 2", "Item 3")

            Spacer(modifier = Modifier.height(32.dp))
            
            // Lista de favoritos
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(30.dp), // Espacio entre cards
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                itemsIndexed(favouriteItems) { index, _ ->
                    FavouriteItemCard(number = index + 1)
                }
            }

            // Botón "Buy" centrado
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBrown),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(vertical = 32.dp)
                    .height(48.dp)
                    .width(130.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add, 
                        contentDescription = null, 
                        modifier = Modifier.size(20.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Buy", 
                        fontSize = 18.sp, 
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(60.dp)) // Espacio para la BottomBar y FAB
        }
    }
}

@Composable
fun FavouriteItemCard(number: Int) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Círculo con número
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(PrimaryBrown),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            // Información del producto
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Leather boots",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextDark
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "27,5 $",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal
                )
            }

            // Imagen a la derecha
            Image(
                painter = painterResource(id = R.drawable.boots),
                contentDescription = "Leather boots image",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(110.dp)
                    .clip(RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavouriteScreenPreview() {
    Challenge2Theme {
        FavouriteScreen(onMenuClick = {}, onNavigate = {})
    }
}
