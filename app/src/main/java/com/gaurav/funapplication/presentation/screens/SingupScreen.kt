package com.gaurav.funapplication.presentation.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gaurav.funapplication.R
import com.gaurav.funapplication.presentation.components.CheckBoxComponent
import com.gaurav.funapplication.presentation.components.HeaderComponent
import com.gaurav.funapplication.presentation.components.MyPasswordFieldComponent
import com.gaurav.funapplication.presentation.components.MyTextFieldComponent
import com.gaurav.funapplication.presentation.components.NormalTextComponent

@Composable
fun SignupScreen() {
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
            HeaderComponent(stringResource(R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldComponent(
                stringResource(R.string.first_name),
                painterResource(R.drawable.ic_profile)
            )
            Spacer(modifier = Modifier.height(10.dp))
            MyTextFieldComponent(
                stringResource(R.string.last_name),
                painterResource(R.drawable.ic_profile)
            )
            Spacer(modifier = Modifier.height(10.dp))
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
            CheckBoxComponent(
                stringResource(R.string.terms_and_conditions),
            )
        }
    }
}

@Preview
@Composable
fun SignupPreview() {
    SignupScreen()
}