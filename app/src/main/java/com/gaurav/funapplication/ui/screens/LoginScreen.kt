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
import com.gaurav.funapplication.ui.uievents.LoginUIEvent
import com.gaurav.funapplication.ui.viewmodel.LoginViewModel
import com.gaurav.funapplication.ui.components.ButtonComponent
import com.gaurav.funapplication.ui.components.ClickableLoginTextComponent
import com.gaurav.funapplication.ui.components.DividerComponent
import com.gaurav.funapplication.ui.components.HeadingTextComponent
import com.gaurav.funapplication.ui.components.MyPasswordFieldComponent
import com.gaurav.funapplication.ui.components.MyTextFieldComponent
import com.gaurav.funapplication.ui.components.NormalTextComponent
import com.gaurav.funapplication.ui.components.UnderlineTextComponent
import com.gaurav.funapplication.navigation.AppRoutes
import okhttp3.Route

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
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
                HeadingTextComponent(stringResource(R.string.welcome_back))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    stringResource(R.string.email),
                    painterResource(R.drawable.ic_email),
                    onTextSelected = {
                        loginViewModel.loginEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
                Spacer(modifier = Modifier.height(10.dp))
                MyPasswordFieldComponent(
                    stringResource(R.string.password),
                    painterResource(R.drawable.ic_lock),
                    onTextSelected = {
                        loginViewModel.loginEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )
                Spacer(modifier = Modifier.height(10.dp))
                UnderlineTextComponent(stringResource(R.string.forgot_password))
                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(
                    stringResource(R.string.login),
                    onButtonClicked = {
                        loginViewModel.loginEvent(LoginUIEvent.LoginButtonClicked)
                        navController.navigate(AppRoutes.HomeScreen.route)
                    },
                    isEnable = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))
                DividerComponent()
                Spacer(modifier = Modifier.height(20.dp))
                ClickableLoginTextComponent(isTryingToLogin = false, onTextSelected = {
                    navController.navigate(AppRoutes.SignupScreen.route)
                })

            }

        }

        if (loginViewModel.loginInProgress.value)
            CircularProgressIndicator()

    }

}