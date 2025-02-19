package com.gaurav.funapplication.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gaurav.funapplication.R
import com.gaurav.funapplication.presentation.components.ButtonComponent
import com.gaurav.funapplication.presentation.components.ClickableLoginTextComponent
import com.gaurav.funapplication.presentation.components.DividerComponent
import com.gaurav.funapplication.presentation.components.HeaderComponent
import com.gaurav.funapplication.presentation.components.MyPasswordFieldComponent
import com.gaurav.funapplication.presentation.components.MyTextFieldComponent
import com.gaurav.funapplication.presentation.components.NormalTextComponent
import com.gaurav.funapplication.presentation.components.UnderlineTextComponent
import com.gaurav.funapplication.presentation.navigation.AppRoutes

@Composable
fun LoginScreen(navController: NavController) {

    BackHandler {
        navController.popBackStack()
    }
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
            HeaderComponent(stringResource(R.string.welcome_back))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(
                stringResource(R.string.email),
                painterResource(R.drawable.ic_email)
            )
            Spacer(modifier = Modifier.height(10.dp))
            MyPasswordFieldComponent(
                stringResource(R.string.password),
                painterResource(R.drawable.ic_lock)
            )
            Spacer(modifier = Modifier.height(10.dp))
            UnderlineTextComponent(stringResource(R.string.forgot_password))
            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(stringResource(R.string.login))
            Spacer(modifier = Modifier.height(20.dp))
            DividerComponent()
            Spacer(modifier = Modifier.height(20.dp))
            ClickableLoginTextComponent(isTryingToLogin = false, onTextSelected = {
                navController.popBackStack()
            })

        }

    }

}