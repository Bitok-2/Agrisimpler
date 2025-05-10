package com.enock.agrisimpler.ui.screens.start


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

import com.enock.agrisimpler.navigation.ROUT_WELCOME
import com.enock.agrisimpler.ui.theme.newOrange
import com.enock.agrisimpler.ui.theme.newgreen2
import com.enock.agrisimpler.ui.theme.newyellow

@Composable
fun StartScreen(navController: NavController){

    Column (
        modifier = Modifier.fillMaxSize().background(color = newyellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ){

        Text(text = "Welcome",
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            color = newOrange



        )
        Spacer(modifier = Modifier.height(20.dp))

        //Circular image
        Image(
            painter = painterResource(R.drawable.appicon),
            contentDescription = "app",
            modifier = Modifier.size(300.dp).clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
        //End
        Spacer(modifier = Modifier.height(20.dp))



        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Focused on connecting farmers worldwide and also providing technological support Welcome All",
            fontSize = 18.sp,
            textAlign = TextAlign.Center


        )
        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = {
                navController.navigate(ROUT_WELCOME)
            },
            colors = ButtonDefaults.buttonColors(newgreen2),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(text = "Get Started!")
        }


    }

}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview(){
    StartScreen(rememberNavController())
    }

