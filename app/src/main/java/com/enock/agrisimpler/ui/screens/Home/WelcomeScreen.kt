package com.enock.agrisimpler.ui.screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
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
import com.enock.agrisimpler.R
import com.enock.agrisimpler.navigation.ROUT_COMMUNITY
import com.enock.agrisimpler.navigation.ROUT_HOME
import com.enock.agrisimpler.navigation.ROUT_MANAGEMENT
import com.enock.agrisimpler.navigation.ROUT_MARKET
import com.enock.agrisimpler.navigation.ROUT_PRODUCT_LIST
import com.enock.agrisimpler.navigation.ROUT_WEATHER
import com.enock.agrisimpler.ui.theme.newOrange
import com.enock.agrisimpler.ui.theme.newgreen2
import com.enock.agrisimpler.ui.theme.newgreen3


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController){
    Column (modifier = Modifier.fillMaxSize().background(Color.White)){

        //Scaffold
        val mContext = LocalContext.current

        var selectedIndex by remember { mutableStateOf(0) }

        Scaffold(
            //TopBar
            topBar = {
                TopAppBar(
                    title = { Text("Home") },

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
                            navController.navigate(ROUT_HOME)
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
                        icon = { Icon(Icons.Default.Info, contentDescription = "Info") },
                        label = { Text("More...",color = Color.White, fontSize = 20.sp) },
                        selected = selectedIndex == 2,
                        onClick = { selectedIndex = 2
                            //  navController.navigate(ROUT_HOME)
                        }
                    )

                }
            },

            //FloatingActionButton
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* Add action */ },
                    containerColor = newOrange
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())

                ){
                    Spacer(modifier = Modifier.height(20.dp))

                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .background(newgreen3)
                        .padding(16.dp),


                    ){
                        Column {
                            Text("Hello", fontSize = 20.sp, color = Color.White)
                            Text("Farmers", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("Sunday, 04 May 2025", fontSize = 14.sp, color = Color.White)

                            Spacer(Modifier.height(10.dp))


//Search Bar
                            var search by remember { mutableStateOf("") }
                            OutlinedTextField(
                                value = search,
                                onValueChange = {search = it},
                                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                                placeholder = { Text(text = "Search...") }

                            )
                            //End of Search Bar

                        }


                    }
                    Spacer(Modifier.height(10.dp))

                    Card (modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable { navController.navigate(ROUT_WEATHER) },
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ){

                    }

                    Spacer(Modifier.height(10.dp))
                    Text("Commodities and Food", modifier = Modifier.padding(horizontal = 16.dp))
                    LazyRow (modifier = Modifier.padding(8.dp)){
                        items(listOf("Rice","Corn","Grapes","Potato","Olive")){item ->
                            Card (modifier = Modifier
                                .padding(8.dp)
                                .clickable { navController.navigate(ROUT_MARKET) }){
                                Box (modifier = Modifier.padding(16.dp)){
                                    Text(item)
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(10.dp))

                    Text("My Fields", modifier = Modifier.padding(horizontal = 16.dp))
                    Card (modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(16.dp)
                        .clickable { navController.navigate(ROUT_PRODUCT_LIST) }
                        ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.product2), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ){}
                            }

                    Spacer(Modifier.height(20.dp))

                    Card (modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(16.dp)
                        .clickable { navController.navigate(ROUT_WEATHER) }
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.weather), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ){}
                    }
                    Spacer(Modifier.height(20.dp))
                    Card (modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(16.dp)
                        .clickable { navController.navigate(ROUT_MARKET) }
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.market), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ){}

                    Spacer(Modifier.height(20.dp))

                        Card (modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(16.dp)
                            .clickable { navController.navigate(ROUT_MANAGEMENT) }
                        ){
                            Column (
                                modifier = Modifier.fillMaxSize()
                                    .paint(painter = painterResource(R.drawable.management), contentScale = ContentScale.FillBounds),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ){}

                    Spacer(Modifier.height(20.dp))

                            Card (modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(16.dp)
                                .clickable { navController.navigate(ROUT_COMMUNITY) }
                            ){
                                Column (
                                    modifier = Modifier.fillMaxSize()
                                        .paint(painter = painterResource(R.drawable.community), contentScale = ContentScale.FillBounds),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                ){}

                    Spacer(Modifier.height(20.dp))








                }


            }


    }





}

            }
        )
    }


}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())

}