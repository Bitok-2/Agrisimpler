package com.enock.agrisimpler.ui.screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.enock.agrisimpler.navigation.ROUT_WEATHER
import com.enock.agrisimpler.ui.theme.newgreen3


@Composable
fun WelcomeScreen(navController: NavController){
    Column (modifier = Modifier.fillMaxSize().background(Color.White)){
        Box (modifier = Modifier
            .fillMaxWidth()
            .background(newgreen3)
            .padding(16.dp)
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
            .paint(painter = painterResource(R.drawable.product2), contentScale = ContentScale.FillBounds)){

        }



    }

}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())

}