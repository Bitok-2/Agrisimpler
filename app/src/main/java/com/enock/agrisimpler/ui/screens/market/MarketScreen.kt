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
import androidx.compose.material.icons.filled.List
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.enock.agrisimpler.R


import com.enock.agrisimpler.navigation.ROUT_MARKET
import com.enock.agrisimpler.navigation.ROUT_PRODUCT_LIST
import com.enock.agrisimpler.navigation.ROUT_SERVICE
import com.enock.agrisimpler.navigation.ROUT_WELCOME
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
                    icon = { Icon(Icons.Default.List, contentDescription = "Profile") },
                    label = { Text("Services",color = Color.White, fontSize = 20.sp) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        navController.navigate(ROUT_SERVICE)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Star,contentDescription = "market") },
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

                Column {

                    //Row


                    //Vegetables


                    Text(text = "VEGETABLES", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Red, fontStyle = FontStyle.Italic)

                    Spacer(modifier = Modifier.height(20.dp))

                    Row (modifier = Modifier.padding(start = 20.dp)){
                        Image(
                            painter = painterResource(R.drawable.cabbages),
                            contentDescription = "cabbage",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Cabbages",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.500",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.450",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.leafygreens),
                            contentDescription = "leafygreens",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Leafy Greens",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.600",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.500",
                                fontSize = 15.sp,


                                )
                            Row {
                               Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.onions),
                            contentDescription = "onions",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Onions",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.70",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.50",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.tomatoes),
                            contentDescription = "tomatoes",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Tomatoes",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.70",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.50",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Contact Us")
                            }

                        }
                    }

                    //End of Row

                    //End of Vegetables

                    //Row2

                    //Fruits
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = "FRUITS", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Magenta)

                    Spacer(modifier = Modifier.height(20.dp))
                    //Row
                    Row (modifier = Modifier.padding(start = 20.dp)){
                        Image(
                            painter = painterResource(R.drawable.apples),
                            contentDescription = "apples",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Apples",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.bananas),
                            contentDescription = "bananas",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Bananas",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.100",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.70",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.berries),
                            contentDescription = "berrries",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Berries",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Contact Us")
                            }

                        }
                    }

                    //End of Row


                    Spacer(modifier = Modifier.height(20.dp))

                    }

                    //End of Row


                    Spacer(modifier = Modifier.height(20.dp))
                    //Row
                    Row (modifier = Modifier.padding(start = 20.dp)){
                        Image(
                            painter = painterResource(R.drawable.oranges),
                            contentDescription = "oranges",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Oranges",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.apples),
                            contentDescription = "mangoes",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Mangoes",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.apples),
                            contentDescription = "pears",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Pears",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.apples),
                            contentDescription = "plums",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Plums",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.apples),
                            contentDescription = "passion",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Passion Fruit",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
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
                            painter = painterResource(R.drawable.apples),
                            contentDescription = "lemon",
                            modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.width(20.dp))

                        Column {
                            Text(text = "Lemons",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold

                            )
                            Text(text = "Ksh.150",
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Text(text = "Price:Ksh.100",
                                fontSize = 15.sp,


                                )
                            Row {
                                Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                            }
                            Button(
                                onClick = {
                                    val callIntent= Intent(Intent.ACTION_DIAL)
                                    callIntent.data="tel:0758638773".toUri()
                                    mContext.startActivity(callIntent)
                                },
                                colors = ButtonDefaults.buttonColors(newgreen2),
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Contact Us")
                            }

                        }
                    }

                    //End of Row2

                //Row3

                //Seeds

                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "SEEDS", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Blue)

                Spacer(modifier = Modifier.height(20.dp))

                //Row
                Row (modifier = Modifier.padding(start = 20.dp)){
                    Image(
                        painter = painterResource(R.drawable.almonds),
                        contentDescription = "almond",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Almonds",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.100",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.50",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
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
                        painter = painterResource(R.drawable.peanuts),
                        contentDescription = "peanut",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Peanuts",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.100",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.50",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
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
                        painter = painterResource(R.drawable.sunflowerseeds),
                        contentDescription = "sunflower",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Sunflower Seeds",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.300",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.200",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
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
                        painter = painterResource(R.drawable.walnuts),
                        contentDescription = "walnut",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Walnuts",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.150",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.100",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Contact Us")
                        }

                    }
                }

                //End of Row3

                //Row4

                //Herbs

                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "HERBS", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Cyan)


                Spacer(modifier = Modifier.height(20.dp))

                //Row
                Row (modifier = Modifier.padding(start = 20.dp)){
                    Image(
                        painter = painterResource(R.drawable.basil),
                        contentDescription = "basil",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Basil",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.100",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.50",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
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
                        painter = painterResource(R.drawable.cilantro),
                        contentDescription = "cilantro",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Cilantro",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.100",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.50",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
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
                        painter = painterResource(R.drawable.mint),
                        contentDescription = "mint",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Mint",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.100",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.50",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
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
                        painter = painterResource(R.drawable.turmeric),
                        contentDescription = "turmeric",
                        modifier = Modifier.width(200.dp).width(150.dp).clip(shape = RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Turmeric",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                        Text(text = "Ksh.200",
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(text = "Price:Ksh.150",
                            fontSize = 15.sp,


                            )
                        Row {
                            Text(text = "View details...", fontSize = 10.sp, color = Color.Blue)
                        }
                        Button(
                            onClick = {
                                val callIntent= Intent(Intent.ACTION_DIAL)
                                callIntent.data="tel:0758638773".toUri()
                                mContext.startActivity(callIntent)
                            },
                            colors = ButtonDefaults.buttonColors(newgreen2),
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
    )
        }





@Preview(showBackground = true)
@Composable
fun MarketScreenPreview(){
    MarketScreen(rememberNavController())

}