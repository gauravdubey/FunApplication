package com.gaurav.funapplication.data.signup

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.gaurav.funapplication.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth

class SignupViewModel : ViewModel() {

    private val TAG = SignupViewModel::class.simpleName
    var registrationUIState = mutableStateOf(SignupUIState())
    var allValidationsPassed = mutableStateOf(false)
    var signupInProgress = mutableStateOf(false)

    /**
     * Handle event for all views
     */
    fun onSignupEvent(event: SignupUIEvent) {
        validateDataWithRules()
        when (event) {
            is SignupUIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
            }

            is SignupUIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
            }

            is SignupUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
            }

            is SignupUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
            }

            is SignupUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState.value = registrationUIState.value.copy(
                    privacyPolicyAccepted = event.status
                )
            }

            is SignupUIEvent.RegisterButtonClicked -> {
                signUp()
            }
        }
    }

    /**
     * Register a new user
     */
    private fun signUp() {
        println("Inside signUp")
        printState()
        createUserInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    /**
     * Validate all the data with the rules
     */
    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )
        val lNameResult = Validator.validateLastName(
            lName = registrationUIState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )
        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = registrationUIState.value.privacyPolicyAccepted
        )
        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status
        )

        allValidationsPassed.value =
            fNameResult.status && lNameResult.status && emailResult.status && passwordResult.status && privacyPolicyResult.status
    }

    /**
     * Print the state of Registration
     */
    private fun printState() {
        println("Inside printState")
        println("LoginViewModel state: ${registrationUIState.value}")
    }

    /**
     * Create a new user in Firebase
     */
    private fun createUserInFirebase(
        email: String,
        password: String
    ) {
        signupInProgress.value=true
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_create_user_In_Firebase")
                Log.d(TAG,"${it.isSuccessful}")
                signupInProgress.value=false
                if (it.isSuccessful) {
                    Log.d(TAG, "Successfully created user in firebase")
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Failed to create user in firebase")
            }
    }
}