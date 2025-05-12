package com.enock.agrisimpler.ui.screens.market

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.enock.agrisimpler.R
import com.enock.agrisimpler.navigation.ROUT_MARKET
import com.enock.agrisimpler.navigation.ROUT_PRODUCT_LIST
import com.enock.agrisimpler.navigation.ROUT_SERVICE
import com.enock.agrisimpler.navigation.ROUT_WELCOME
import com.enock.agrisimpler.ui.theme.newgreen2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(3) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Services",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle menu */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newgreen2
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = newgreen2) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home", color = Color.White) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_WELCOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Products") },
                    label = { Text("Products", color = Color.White) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_PRODUCT_LIST)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Profile") },
                    label = { Text("Services", color = Color.White) },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        // Future profile route
                        navController.navigate(ROUT_SERVICE)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Star, contentDescription = "Market") },
                    label = { Text("Market", color = Color.White) },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(ROUT_MARKET)
                    }
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Search Bar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    placeholder = { Text("Search...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(20.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Banner with Background Image
                val cardShape = RoundedCornerShape(16.dp)
                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(160.dp),
                    shape = cardShape
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Background Image with Rounded Corners
                        Image(
                            painter = painterResource(id = R.drawable.farmbanner), // Replace with your image name
                            contentDescription = "Discount Background",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(cardShape)
                        )

                        // Optional dark overlay
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0x66000000)) // semi-transparent black
                        )

                        // Foreground content
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Offer",
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Discount 15%\nOn All Services",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Categories
                Text(
                    "Categories",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 16.dp)
                )

                val categories = listOf("Planting", "Maintenance", "Pest", "Harvest")
                LazyRow(modifier = Modifier.padding(8.dp)) {
                    items(categories) { category ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .clickable { /* Navigate to category */ }
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(70.dp)
                                    .background(Color(0xFFE8F5E9), shape = CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = when (category) {
                                        "Planting" -> Icons.Default.LocationOn
                                        "Maintenance" -> Icons.Default.Build
                                        "Pest" -> Icons.Default.Refresh
                                        "Harvest" -> Icons.Default.DateRange
                                        else -> Icons.Default.Info
                                    },
                                    contentDescription = category,
                                    tint = newgreen2,
                                    modifier = Modifier.size(36.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = category, fontSize = 14.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Special Deals
                Text(
                    "Special Deals",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 16.dp)
                )

                val dealImages = listOf(
                    R.drawable.service1,
                    R.drawable.maintenance2,
                    R.drawable.harvest2
                )

                LazyRow(modifier = Modifier.padding(8.dp)) {
                    items(dealImages) { imageResId ->
                        Card(
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .size(width = 180.dp, height = 180.dp)
                                .padding(end = 12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = "Service Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ServiceScreenPreview() {
    ServiceScreen(rememberNavController())
}
