package com.gaurav.funapplication.data.home

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {

    private val TAG = HomeViewModel::class.simpleName
    val navigationItemList = listOf(
        NavigationItems(
            title = "Profile",
            description = "Profile Screen",
            itemId = 1,
            icon = Icons.Default.Person
        ),
        NavigationItems(
            title = "Home",
            description = "Home Screen",
            itemId = 2,
            icon = Icons.Default.Home
        ),
        NavigationItems(
            title = "Settings",
            description = "Settings Screen",
            itemId = 3,
            icon = Icons.Default.Settings
        ),
        NavigationItems(
            title = "Favorite",
            description = "Favorite Screen",
            itemId = 4,
            icon = Icons.Default.Favorite
        )
    )

    /**
     * Logout the current user
     */
    fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "Inside_logout")

            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }
}