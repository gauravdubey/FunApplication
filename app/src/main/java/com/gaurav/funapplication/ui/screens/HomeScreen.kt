package com.gaurav.funapplication.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gaurav.funapplication.R
import com.gaurav.funapplication.ui.viewmodel.HomeViewModel
import com.gaurav.funapplication.data.local.entities.NavigationItems
import com.gaurav.funapplication.ui.components.AppToolbar
import com.gaurav.funapplication.ui.components.HeadingTextComponent
import com.gaurav.funapplication.ui.components.NavigationDrawerBody
import com.gaurav.funapplication.ui.components.NavigationDrawerHeader
import com.gaurav.funapplication.ui.components.NormalTextComponent
import com.gaurav.funapplication.navigation.AppRoutes
import com.gaurav.funapplication.ui.application.theme.colorWhite
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(homeViewModel.navigationItemList)
        }
    ) {
        HomeScreenContent(
            navController,
            homeViewModel,
            navigationMenuClick = {
                scope.launch {
                    drawerState.open()
                }
            })
    }
}

/**
 * Drawer Content
 */
@Composable
fun DrawerContent(list: List<NavigationItems>) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .background(colorWhite)
    ) {
        NavigationDrawerHeader()
        NavigationDrawerBody(list,
            onNavigationItemClicked = {
                Log.d("Navigation Item", "DrawerContent: ${it.title}")
            })
    }
}

/**
 * Home Screen Content
 */
@Composable
fun HomeScreenContent(
    navController: NavController,
    homeViewModel: HomeViewModel,
    navigationMenuClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AppToolbar(
                toolbarTitle = stringResource(R.string.home),
                logoutButtonClicked = {
                    homeViewModel.logout()
                    navController.navigate(AppRoutes.LoginScreen.route)
                }, navigationMenuClick
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                HeadingTextComponent("Home Screen")
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComponent(stringResource(R.string.hello))
                Spacer(modifier = Modifier.height(40.dp))
            }

        }
    )
}