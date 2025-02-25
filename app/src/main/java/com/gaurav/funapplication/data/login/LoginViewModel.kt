package com.gaurav.funapplication.data.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.gaurav.funapplication.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    var loginUIState = mutableStateOf(LoginUIState())
    var allValidationsPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)

    /**
     * Handle event for all views
     */
    fun loginEvent(event: LoginUIEvent) {
        validateDataWithRules()
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()

            }
        }
    }


    /**
     * Validate all the data with the rules
     */
    private fun validateDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )
        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status
    }

    /**
     * Login method for logging the user
     */
    private fun login() {
        loginInFirebase(
            email = loginUIState.value.email,
            password = loginUIState.value.password

        )
    }

    /**
     * Login a user in Firebase
     */
    private fun loginInFirebase(email: String, password: String) {
        loginInProgress.value = true
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_login_in_firebase")
                Log.d(TAG, "${it.isSuccessful}")
                loginInProgress.value = false
                if (it.isSuccessful) {
                    Log.d(TAG, "Successfully logged in")
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Failed to log in")
            }
    }


}