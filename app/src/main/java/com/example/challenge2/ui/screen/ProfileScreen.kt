package com.example.challenge2.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.ui.components.AppBottomBar
import com.example.challenge2.ui.components.CentralFAB
import com.example.challenge2.ui.components.TopBarComponent
import com.example.challenge2.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onBack: () -> Unit = {}, onNavigate: (String) -> Unit = {}) {
    Scaffold(
        topBar = {
            TopBarComponent(
                title = "Profile",
                navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
                onNavigationClick = onBack,
                onActionClick = { /* TODO */ }
            )
        },
        bottomBar = { AppBottomBar(currentRoute = "profile", onNavigate = onNavigate) },
        floatingActionButton = { CentralFAB { /* TODO */ } },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(BackgroundBeige)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Profile Image Area (139 x 139)
            Box(contentAlignment = Alignment.BottomEnd) {
                Box(
                    modifier = Modifier
                        .size(139.dp)
                        .clip(CircleShape)
                        .background(PlaceholderGray)
                )
                
                // Edit Button
                Surface(
                    onClick = { /* TODO */ },
                    shape = CircleShape,
                    color = OrangeEdit,
                    modifier = Modifier
                        .size(36.dp)
                        .offset(x = (-4).dp, y = (-4).dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Profile",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            // Espacio de 18px entre foto y nombre
            Spacer(modifier = Modifier.height(18.dp))

            // Name - 20sp, SemiBold
            Text(
                text = "Martin",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextDark
            )
            
            // Espacio de 8dp entre nombre y rol
            Spacer(modifier = Modifier.height(8.dp))
            
            // Role - 14sp, Regular (Weight 400)
            Text(
                text = "UI UX DESIGN",
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Color.Gray.copy(alpha = 0.6f),
                letterSpacing = 1.sp
            )

            // Espacio de 59dp entre el rol y el primer input
            Spacer(modifier = Modifier.height(59.dp))

            // Information Fields
            ProfileField(
                label = "E-Mail Address",
                value = "xxx@gmail.com",
                icon = Icons.Outlined.Email
            )
            
            // Espacio de 40dp entre inputs
            Spacer(modifier = Modifier.height(40.dp))
            
            ProfileField(
                label = "Phone Number",
                value = "+5493123135",
                icon = Icons.Outlined.Phone
            )
            
            // Espacio de 40dp entre inputs
            Spacer(modifier = Modifier.height(40.dp))
            
            ProfileField(
                label = "Web Site",
                value = "www.google.com",
                icon = Icons.Outlined.Settings
            )
            
            // Espacio de 40dp entre inputs
            Spacer(modifier = Modifier.height(40.dp))

            ProfileField(
                label = "Password",
                value = "xxxxxxxxxxxxxx",
                icon = Icons.Outlined.Lock
            )
            
            // Espacio extra al final para permitir scroll completo sobre el FAB
            Spacer(modifier = Modifier.height(120.dp))
        }
    }
}

@Composable
fun ProfileField(
    label: String,
    value: String,
    icon: ImageVector
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = { Text(label, fontSize = 14.sp) },
        readOnly = true,
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium // Weight 500
        ),
        modifier = Modifier
            .width(364.dp)
            .height(56.dp),
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Gray.copy(alpha = 0.6f),
                modifier = Modifier.size(24.dp)
            )
        },
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Gray.copy(alpha = 0.4f),
            focusedBorderColor = PrimaryBrown,
            unfocusedLabelColor = Color.Gray.copy(alpha = 0.7f),
            focusedLabelColor = PrimaryBrown,
            unfocusedTextColor = Color.Gray.copy(alpha = 0.7f)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Challenge2Theme {
        ProfileScreen()
    }
}
