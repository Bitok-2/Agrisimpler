package com.enock.agrisimpler.ui.screens.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun WeatherScreen(navController: NavController){

}

@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview(){
    WeatherScreen(rememberNavController())

}