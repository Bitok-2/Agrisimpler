package com.enock.agrisimpler.ui.screens.Refer

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.enock.agrisimpler.navigation.ROUT_WELCOME
import com.enock.agrisimpler.ui.theme.newgreen2


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ManagementScreen(navController: NavController){
    //Scaffold
    val mContext = LocalContext.current

    var selectedIndex by remember { mutableStateOf(0) }

    @Composable
    fun ActionButton(s: String, add: Any, content: @Composable () -> Unit) {
        TODO("Not yet implemented")
    }
    Scaffold(
    //TopBar
    topBar = {
        TopAppBar(
            title = { Text("Market") },

            navigationIcon = {
                IconButton(onClick = { /* Handle back/nav */ }) {
                    Icon(Icons.Default.Menu, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = newgreen2,
                titleContentColor = Color.White,
                navigationIconContentColor = Color.White
            )
        )
    },

    //BottomBar
    bottomBar = {
        NavigationBar(
            containerColor = newgreen2
        ){
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home", color = Color.White, fontSize = 20.sp) },
                selected = selectedIndex == 0,
                onClick = { selectedIndex = 0
                    navController.navigate(ROUT_WELCOME)
                }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Services") },
                label = { Text("Products",color = Color.White, fontSize = 20.sp) },
                selected = selectedIndex == 1,
                onClick = { selectedIndex = 1
                    navController.navigate(ROUT_PRODUCT_LIST)
                }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                label = { Text("Profile",color = Color.White, fontSize = 20.sp) },
                selected = selectedIndex == 2,
                onClick = { selectedIndex = 2
                    //  navController.navigate(ROUT_HOME)
                }
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Star,contentDescription = "Info") },
                label = { Text("Market",color = Color.White, fontSize = 20.sp) },
                selected = selectedIndex == 2,
                onClick = { selectedIndex = 2
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


                //Main Contents of the page
                Spacer(modifier = Modifier.height(20.dp))

//Search Bar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(24.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    },
                    placeholder = { Text(text = "Search...") }
                )
                //End of Search Bar

                Spacer(modifier = Modifier.height(20.dp))

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        UserGreeting()
                    }
                    item {
                        FarmOverviewCard()
                    }
                    item {
                        QuickActionsGrid()
                    }
                    item {
                        ActivityLog()
                    }
                    item {
                        TipCard()
                    }
                }
            }


        @Composable
        fun UserGreeting() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.farmerprofile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color.LightGray, CircleShape)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Welcome back,", fontSize = 16.sp)
                    Text("Enock", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            }
        }

        @Composable
        fun FarmOverviewCard() {
            Card(
                shape = RoundedCornerShape(12.dp),
                
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Today on the Farm", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("☀️ Weather: Sunny, 28°C")
                    Text("🌱 Soil Moisture: Optimal")
                    Text("📅 Next Task: Water tomatoes at 4 PM")
                }
            }
        }

        @Composable
        fun QuickActionsGrid() {
            Column {
                Text("Quick Actions", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    ActionButton("Add Crop", Icons.Default.Add) { /* navController.navigate(...) */ }
                    ActionButton("Reports", Icons.Default.CheckCircle) {}
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    ActionButton("Expenses", Icons.Default.AccountBox) {}
                    ActionButton("Livestock", Icons.Default.ExitToApp) {}
                }
            }
        }

        @Composable
        fun ActionButton(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
            Card(
                shape = RoundedCornerShape(12.dp),

                modifier = Modifier
                    .clickable(onClick = onClick)
                    .padding(4.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(icon, contentDescription = label, tint = Color(0xFF4CAF50), modifier = Modifier.size(32.dp))
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
            Card(
                shape = RoundedCornerShape(12.dp),

                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Info, contentDescription = "Tip", tint = Color(0xFF388E3C), modifier = Modifier.size(32.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("🌽 Tip: Rotate your crops every season to improve soil health and yield.")
                }
            }
        }









}
    )

        }

@Composable
fun TipCard() {
    TODO("Not yet implemented")
}

@Composable
fun ActivityLog() {
    TODO("Not yet implemented")
}

@Composable
fun QuickActionsGrid() {
    TODO("Not yet implemented")
}

@Composable
fun FarmOverviewCard() {
    TODO("Not yet implemented")
}

@Composable
fun UserGreeting() {
    TODO("Not yet implemented")
}


@Preview(showBackground = true)
@Composable
fun ManagementScreenPreview(){
    ManagementScreen (rememberNavController())

}