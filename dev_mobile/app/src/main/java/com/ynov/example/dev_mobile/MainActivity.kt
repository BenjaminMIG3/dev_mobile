package com.ynov.example.dev_mobile

import ShowDetailsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ynov.example.dev_mobile.presentation.PopularShowsScreen

import com.ynov.example.dev_mobile.ui.theme.Dev_mobileTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dev_mobileTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "popular") {
                    composable("popular") {
                        PopularShowsScreen(
                            onShowClick = { showId ->
                                navController.navigate("details/$showId")
                            }
                        )
                    }
                    composable("details/{showId}") { backStackEntry ->
                        ShowDetailsScreen(
                            showId = backStackEntry.arguments?.getString("showId") ?: "",
                            navController = navController // Ajoutez ceci pour le bouton de retour
                        )
                    }
                }
            }
        }
    }
}