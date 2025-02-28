package com.gaurav.funapplication.ui.uievents

sealed class SignupUIEvent {
    data class FirstNameChanged(var firstName: String) : SignupUIEvent()
    data class LastNameChanged(var lastName: String) : SignupUIEvent()
    data class EmailChanged(var email: String) : SignupUIEvent()
    data class PasswordChanged(var password: String) : SignupUIEvent()
    data class PrivacyPolicyCheckBoxClicked(var status: Boolean) : SignupUIEvent()
    data object RegisterButtonClicked : SignupUIEvent()
}