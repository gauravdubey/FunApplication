package com.gaurav.funapplication.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gaurav.funapplication.R
import com.gaurav.funapplication.ui.uievents.SignupUIEvent
import com.gaurav.funapplication.ui.viewmodel.SignupViewModel
import com.gaurav.funapplication.ui.components.ButtonComponent
import com.gaurav.funapplication.ui.components.CheckBoxComponent
import com.gaurav.funapplication.ui.components.ClickableLoginTextComponent
import com.gaurav.funapplication.ui.components.DividerComponent
import com.gaurav.funapplication.ui.components.HeadingTextComponent
import com.gaurav.funapplication.ui.components.MyPasswordFieldComponent
import com.gaurav.funapplication.ui.components.MyTextFieldComponent
import com.gaurav.funapplication.ui.components.NormalTextComponent
import com.gaurav.funapplication.navigation.AppRoutes

@Composable
fun SignupScreen(
    navController: NavController,
    signupViewModel: SignupViewModel = viewModel()
) {
    BackHandler {
        navController.popBackStack()
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComponent(stringResource(R.string.hello))
                HeadingTextComponent(stringResource(R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    stringResource(R.string.first_name),
                    painterResource(R.drawable.ic_profile),
                    onTextSelected = {
                        signupViewModel.onSignupEvent(SignupUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )
                Spacer(modifier = Modifier.height(10.dp))
                MyTextFieldComponent(
                    stringResource(R.string.last_name),
                    painterResource(R.drawable.ic_profile),
                    onTextSelected = {
                        signupViewModel.onSignupEvent(SignupUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )
                Spacer(modifier = Modifier.height(10.dp))
                MyTextFieldComponent(
                    stringResource(R.string.email),
                    painterResource(R.drawable.ic_email),
                    onTextSelected = {
                        signupViewModel.onSignupEvent(SignupUIEvent.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )
                Spacer(modifier = Modifier.height(10.dp))
                MyPasswordFieldComponent(
                    stringResource(R.string.password),
                    painterResource(R.drawable.ic_lock),
                    onTextSelected = {
                        signupViewModel.onSignupEvent(SignupUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError
                )
                Spacer(modifier = Modifier.height(10.dp))
                CheckBoxComponent(
                    stringResource(R.string.terms_and_conditions),
                    onTextSelected = {
                        navController.navigate(AppRoutes.TermsAndConditionsScreen.route) {
                            popUpTo(AppRoutes.SignupScreen.route) { inclusive = true }
                        }
                    },
                    onCheckChanged = {
                        signupViewModel.onSignupEvent(
                            SignupUIEvent.PrivacyPolicyCheckBoxClicked(
                                it
                            )
                        )
                    }
                )
                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(
                    stringResource(R.string.register),
                    onButtonClicked = {
                        signupViewModel.onSignupEvent(SignupUIEvent.RegisterButtonClicked)
                        navController.navigate(AppRoutes.HomeScreen.route)
                    },
                    isEnable = signupViewModel.allValidationsPassed.value
                )
                Spacer(modifier = Modifier.height(20.dp))
                DividerComponent()
                Spacer(modifier = Modifier.height(20.dp))
                ClickableLoginTextComponent(isTryingToLogin = true, onTextSelected = {
                    navController.navigate(AppRoutes.LoginScreen.route)
                })
            }
        }

        if (signupViewModel.signupInProgress.value)
            CircularProgressIndicator()
    }

}