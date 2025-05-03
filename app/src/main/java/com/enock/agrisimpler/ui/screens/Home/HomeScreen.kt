package com.enock.agrisimpler.ui.screens.Home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.enock.agrisimpler.ui.theme.newWhite
import com.enock.agrisimpler.ui.theme.newgreen
import com.enock.agrisimpler.ui.theme.newgreen2
import com.enock.agrisimpler.ui.theme.newscarl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

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
            ) {


                //Main Contents of the page
                Spacer(modifier = Modifier.height(20.dp))

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

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(R.drawable.farmer1),
                    contentDescription = "agri",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.FillWidth

                )

                Spacer(modifier = Modifier.height(50.dp))

                //Row
                Row (modifier = Modifier.padding(start = 20.dp)){


                    //Card1
                    Card (
                        modifier = Modifier.width(150.dp).height(180.dp).clickable { navController.navigate(
                            ROUT_HOME) },
                        colors = CardColors(
                            newscarl,
                            contentColor = newWhite,
                            disabledContainerColor = newOrange,
                            disabledContentColor = newWhite
                        )
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.bgimage3), contentScale = ContentScale.FillBounds)
                            ,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,

                        ){
                            Text(text = "Home", fontSize = 15.sp)


                        }
                    }

                    //End of Card1
                    Spacer(modifier = Modifier.width(20.dp))


                    //Card2
                    Card (
                        modifier = Modifier.width(150.dp).height(180.dp).clickable { navController.navigate(
                            ROUT_PRODUCT_LIST) }
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.product2), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){

                            Text(text = "Products", fontSize = 15.sp)
                        }
                    }
                    //End of Card2


                }
                //Emd of Row

                Spacer(modifier = Modifier.height(20.dp).clickable { navController.navigate(
                    ROUT_MARKET) })


                //Row2
                Row (modifier = Modifier.padding(start = 20.dp)){
                    //Card1
                    Card (
                        modifier = Modifier.width(150.dp).height(180.dp)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.market), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){

                            Text(text = "Market", fontSize = 15.sp)
                        }
                    }
                    //End of Card1
                    Spacer(modifier = Modifier.width(20.dp))
                    //Card2
                    Card (
                        modifier = Modifier.width(150.dp).height(180.dp).clickable { navController.navigate(
                            ROUT_MANAGEMENT) }
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.management), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){

                            Text(text = "Management", fontSize = 15.sp)
                        }
                    }
                    //End of Card2
                }
                //Emd of Row2

                //Row3
                Row (modifier = Modifier.padding(start = 20.dp)){
                    //Card1
                    Card (
                        modifier = Modifier.width(150.dp).height(180.dp).clickable { navController.navigate(
                            ROUT_WEATHER) }
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.weather), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){

                            Text(text = "Weather updates", fontSize = 15.sp)
                        }
                    }
                    //End of Card1
                    Spacer(modifier = Modifier.width(20.dp))
                    //Card2
                    Card (
                        modifier = Modifier.width(150.dp).height(180.dp).clickable { navController.navigate(
                            ROUT_COMMUNITY) }
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize()
                                .paint(painter = painterResource(R.drawable.community), contentScale = ContentScale.FillBounds),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){

                            Text(text = "Community/Share ideas", fontSize = 15.sp)
                        }
                    }
                    //End of Card2
                }
                //Emd of Row3













            }
        }
    )

    //End of scaffold



}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())

}