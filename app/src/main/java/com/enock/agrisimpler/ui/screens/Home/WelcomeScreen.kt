package com.enock.agrisimpler.ui.screens.Home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.enock.agrisimpler.R
import com.enock.agrisimpler.navigation.*

import com.enock.agrisimpler.navigation.ROUT_COMMUNITY
import com.enock.agrisimpler.navigation.ROUT_MANAGEMENT
import com.enock.agrisimpler.navigation.ROUT_MARKET
import com.enock.agrisimpler.navigation.ROUT_PRODUCT_LIST
import com.enock.agrisimpler.navigation.ROUT_WEATHER
import com.enock.agrisimpler.ui.theme.newOrange
import com.enock.agrisimpler.ui.theme.newgreen2
import com.enock.agrisimpler.ui.theme.newgreen3
import kotlinx.coroutines.delay

@Composable
fun AnimatedLottieIntro() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.drawable.farm))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
    )
}

@Composable
fun ImageCarousel(images: List<Int>) {
    var currentIndex by remember { mutableStateOf(0) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentIndex = (currentIndex + 1) % images.size
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(images[currentIndex]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = newgreen2,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
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
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile", color = Color.White) },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "More") },
                    label = { Text("More...", color = Color.White) },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = newOrange
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(12.dp))



            Spacer(modifier = Modifier.height(16.dp))

            ImageCarousel(
                images = listOf(
                    R.drawable.product2,
                    R.drawable.weather,
                    R.drawable.market
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Hello Farmers",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = newgreen2,
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                "Sunday, 04 May 2025",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(24.dp),
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                placeholder = { Text("Search...") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            HomeCard(R.drawable.product2, "My Fields") { navController.navigate(ROUT_PRODUCT_LIST) }
            HomeCard(R.drawable.weather, "Weather") { navController.navigate(ROUT_WEATHER) }
            HomeCard(R.drawable.market, "Market") { navController.navigate(ROUT_MARKET) }
            HomeCard(R.drawable.management, "Management") { navController.navigate(ROUT_MANAGEMENT) }
            HomeCard(R.drawable.community, "Community") { navController.navigate(ROUT_COMMUNITY) }
        }
    }
}

@Composable
fun HomeCard(imageRes: Int, title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(150.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))))
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}
