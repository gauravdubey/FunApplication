package com.gaurav.funapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gaurav.funapplication.presentation.screens.HomeScreen
import com.gaurav.funapplication.presentation.screens.LoginScreen
import com.gaurav.funapplication.presentation.screens.SignupScreen
import com.gaurav.funapplication.presentation.screens.TermsAndConditionsScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppRoutes.SignupScreen.route) {
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