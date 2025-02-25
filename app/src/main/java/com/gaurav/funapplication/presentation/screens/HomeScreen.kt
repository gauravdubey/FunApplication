package com.gaurav.funapplication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gaurav.funapplication.R
import com.gaurav.funapplication.data.login.LoginViewModel
import com.gaurav.funapplication.presentation.components.AppToolbar
import com.gaurav.funapplication.presentation.components.HeaderComponent
import com.gaurav.funapplication.presentation.components.NormalTextComponent
import com.gaurav.funapplication.presentation.navigation.AppRoutes

@Composable
fun HomeScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            AppToolbar(toolbarTitle = stringResource(R.string.home),
                logoutButtonClicked = {
                    loginViewModel.logout()
                    navController.navigate(AppRoutes.LoginScreen.route)
                })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                HeaderComponent("Home Screen")
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComponent(stringResource(R.string.hello))
                Spacer(modifier = Modifier.height(40.dp))
            }

        }
    )
}
