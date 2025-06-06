package com.enock.agrisimpler.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.enock.agrisimpler.data.UserDatabase
import com.enock.agrisimpler.repository.UserRepository

import com.enock.agrisimpler.ui.screens.Home.WelcomeScreen

import com.enock.agrisimpler.ui.screens.auth.LoginScreen
import com.enock.agrisimpler.ui.screens.auth.RegisterScreen
import com.enock.agrisimpler.ui.screens.community.CommunityScreen
import com.enock.agrisimpler.ui.screens.dashboard.DashboardScreen
import com.enock.agrisimpler.ui.screens.management.AnalysisScreen
import com.enock.agrisimpler.ui.screens.management.IrrigationScreen

import com.enock.agrisimpler.ui.screens.market.MarketScreen
import com.enock.agrisimpler.ui.screens.notifications.NotificationsScreen
import com.enock.agrisimpler.ui.screens.products.AddProductScreen
import com.enock.agrisimpler.ui.screens.products.EditProductScreen
import com.enock.agrisimpler.ui.screens.products.ProductListScreen

import com.enock.agrisimpler.ui.screens.management.ManagementScreen
import com.enock.agrisimpler.ui.screens.market.ServiceScreen
import com.enock.agrisimpler.ui.screens.products.AdminAddProductScreen
import com.enock.agrisimpler.ui.screens.splash.SplashScreen
import com.enock.agrisimpler.ui.screens.start.StartScreen

import com.enock.agrisimpler.ui.screens.weather.WeatherScreen
import com.enock.agrisimpler.viewmodel.AuthViewModel
import com.enock.agrisimpler.viewmodel.ProductViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,
    productViewModel: ProductViewModel = viewModel(),
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_START) {
            StartScreen (navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen (navController)
        }
        composable(ROUT_MANAGEMENT) {
            ManagementScreen  (navController)
        }
        composable(ROUT_WEATHER) {
            WeatherScreen   (navController)
        }
        composable(ROUT_ANALYSIS) {
            AnalysisScreen (navController)
        }
        composable(ROUT_IRRIGATION) {
            IrrigationScreen (navController)
        }
        composable(ROUT_MARKET) {
            MarketScreen (navController)
        }
        composable(ROUT_NOTIFICATION) {
            NotificationsScreen (navController)
        }
        composable(ROUT_COMMUNITY) {
            CommunityScreen (navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen (navController)
        }
        composable(ROUT_WELCOME) {
            WelcomeScreen (navController)
        }
        composable(ROUT_SERVICE) {
            ServiceScreen (navController)
        }

        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_WELCOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }
        composable(ROUT_ADMINADDPRODUCT) {
            AdminAddProductScreen (navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }



    }
}