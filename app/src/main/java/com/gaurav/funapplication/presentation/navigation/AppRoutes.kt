package com.gaurav.funapplication.presentation.navigation

sealed class AppRoutes (val route:String){
    data object SignupScreen : AppRoutes("signup")
    data object LoginScreen : AppRoutes("login")
    data object TermsAndConditionsScreen : AppRoutes("terms")
    data object HomeScreen : AppRoutes("home")
}