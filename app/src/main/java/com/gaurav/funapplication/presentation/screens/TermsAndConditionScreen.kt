package com.gaurav.funapplication.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gaurav.funapplication.R
import com.gaurav.funapplication.presentation.components.HeaderComponent

@Composable
fun TermsAndConditionsScreen(navController: NavController) {

    BackHandler {
        navController.popBackStack()
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        HeaderComponent(value = stringResource(R.string.tnc_header))
    }
}