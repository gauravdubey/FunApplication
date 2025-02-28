package com.gaurav.funapplication.ui.uievents

sealed class LoginUIEvent {
    data class EmailChanged(var email: String) : LoginUIEvent()
    data class PasswordChanged(var password: String) : LoginUIEvent()
    data object LoginButtonClicked : LoginUIEvent()
}