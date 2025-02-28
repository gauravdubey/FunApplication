package com.gaurav.funapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gaurav.funapplication.ui.screens.HomeScreen
import com.gaurav.funapplication.ui.screens.LoginScreen
import com.gaurav.funapplication.ui.screens.SignupScreen
import com.gaurav.funapplication.ui.screens.TermsAndConditionsScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppRoutes.LoginScreen.route) {
        composable(AppRoutes.SignupScreen.route) {
            SignupScreen(navController)
        }
        composable(AppRoutes.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(AppRoutes.TermsAndConditionsScreen.route) {
            TermsAndConditionsScreen(navController)
        }
        composable(AppRoutes.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}