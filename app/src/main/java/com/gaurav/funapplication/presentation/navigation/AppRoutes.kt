package com.gaurav.funapplication.presentation.navigation

sealed class AppRoutes (val route:String){
    object SignupScreen : AppRoutes("signup")
    object LoginScreen : AppRoutes("login")
    object TermsAndConditionsScreen : AppRoutes("terms")

}