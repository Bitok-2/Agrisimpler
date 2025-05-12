package com.enock.agrisimpler.ui.screens.management

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

@Composable
fun SafeImage(
    resourceId: Int,
    description: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    val isInPreview = LocalInspectionMode.current
    if (isInPreview) {
        Box(
            modifier = modifier
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = description,
                color = Color.DarkGray,
                fontSize = 12.sp
            )
        }
    } else {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = description,
            modifier = modifier,
            contentScale = contentScale
        )
    }
}

@Composable
fun ManagementScreenContent(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    onNavigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        var search by remember { mutableStateOf("") }
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(24.dp),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            placeholder = { Text("Search...") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            UserGreeting()
            FarmOverviewCard()
            QuickActionsGrid()
            ActivityLog()
            TipCard()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagementScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Market") },
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
                    label = { Text("Home", color = Color.White, fontSize = 14.sp) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_WELCOME) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Products") },
                    label = { Text("Products", color = Color.White, fontSize = 14.sp) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_PRODUCT_LIST) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Profile") },
                    label = { Text("Services", color = Color.White, fontSize = 14.sp) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_SERVICE)

                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Star, contentDescription = "Market") },
                    label = { Text("Market", color = Color.White, fontSize = 14.sp) },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(ROUT_MARKET) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            ManagementScreenContent(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it },
                onNavigate = { navController.navigate(it) }
            )
        }
    }
}

@Composable
fun UserGreeting() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color(0xFFE8F5E9))
    ) {
        Image(
            painter = painterResource(id = R.drawable.farmbanner), // Replace with your image name
            contentDescription = "Discount Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, top = 60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.farmerprofile), // Replace with your image name
                contentDescription = "Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .padding(4.dp)

            )

            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Welcome back,", fontSize = 16.sp, color = Color.White)
                Text("Enock", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun FarmOverviewCard() {
    Card(shape = RoundedCornerShape(12.dp), modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Today on the Farm", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.farmoverview), // Replace with your image name
                contentDescription = "Discount Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),


            )

            Spacer(modifier = Modifier.height(8.dp))
            Text("\u2600\ufe0f Weather: Sunny, 28\u00b0C")
            Text("\ud83c\udf31 Soil Moisture: Optimal")
            Text("\ud83d\uddd3 Next Task: Water tomatoes at 4 PM")
        }
    }
}

@Composable
fun QuickActionsGrid() {
    Column {
        Text("Quick Actions", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ActionButton("Add Crop", Icons.Default.Add, {}, R.drawable.add)
            ActionButton("Reports", Icons.Default.CheckCircle, {}, R.drawable.report)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ActionButton("Expenses", Icons.Default.AccountBox, {}, R.drawable.expense)
            ActionButton("Livestock", Icons.Default.ExitToApp, {}, R.drawable.livestock)
        }
    }
}

@Composable
fun ActionButton(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
    imageRes: Int? = null
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = onClick)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            if (imageRes != null) {
                SafeImage(resourceId = imageRes, description = label, modifier = Modifier.size(40.dp))
            } else {
                Icon(icon, contentDescription = label, tint = Color(0xFF4CAF50), modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(label, fontSize = 14.sp)
        }
    }
}

@Composable
fun ActivityLog() {
    Column {
        Text("Recent Activity", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text("• Added 20 kg fertilizer to maize")
        Text("• Recorded expense: KES 1,200 on seeds")
        Text("• Scheduled irrigation for greenhouse")
    }
}

@Composable
fun TipCard() {
    Card(shape = RoundedCornerShape(12.dp), modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            SafeImage(
                resourceId = R.drawable.tip,
                description = "Tip",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("\ud83c\udf3d Tip: Rotate your crops every season to improve soil health and yield.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManagementScreenPreview() {
    MaterialTheme {
        ManagementScreenContent(
            selectedIndex = 0,
            onItemSelected = {},
            onNavigate = {}
        )
    }
}
