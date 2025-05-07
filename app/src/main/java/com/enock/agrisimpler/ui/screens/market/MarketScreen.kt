package com.enock.agrisimpler.ui.screens.market

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.enock.agrisimpler.R

import com.enock.agrisimpler.navigation.ROUT_HOME
import com.enock.agrisimpler.navigation.ROUT_MARKET
import com.enock.agrisimpler.navigation.ROUT_PRODUCT_LIST
import com.enock.agrisimpler.ui.theme.newOrange
import com.enock.agrisimpler.ui.theme.newgreen2



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MarketScreen(navController: NavController){
    //Scaffold
    val mContext = LocalContext.current

    var selectedIndex by remember { mutableStateOf(0) }

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

                Column (modifier = Modifier.verticalScroll(rememberScrollState())){

                    //Row
                    Row (modifier = Modifier.padding(start = 20.dp)){
                        Image(
                            painter = painterResource(R.drawable.hood),
                            contentDescription = "shopping",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Men's Outfit",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.65,000",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.62,000",
                                fontSize = 15.sp,


                                )
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0720245837".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newOrange),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Contact Us")
                            }

                        }
                    }

                    //End of Row

                    Spacer(modifier = Modifier.height(20.dp))

                    //Row
                    Row (modifier = Modifier.padding(start = 20.dp)){
                        Image(
                            painter = painterResource(R.drawable.hood),
                            contentDescription = "shopping",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Men's Outfit",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.65,000",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.62,000",
                                fontSize = 15.sp,


                                )
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                            }
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(newOrange),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Contact Us")
                            }

                        }
                    }

                    //End of Row


                    Spacer(modifier = Modifier.height(20.dp))

                    //Row
                    Row (modifier = Modifier.padding(start = 20.dp)){
                        Image(
                            painter = painterResource(R.drawable.hood),
                            contentDescription = "shopping",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Men's Outfit",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.65,000",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.62,000",
                                fontSize = 15.sp,


                                )
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                                Icon(imageVector = Icons.Default.Star, contentDescription = "", tint = newOrange)
                            }
                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(newOrange),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Contact Us")
                            }

                        }
                    }

                    //End of Row
                }






            }
        }
    )
}



@Preview(showBackground = true)
@Composable
fun MarketScreenPreview(){
    MarketScreen(rememberNavController())

}