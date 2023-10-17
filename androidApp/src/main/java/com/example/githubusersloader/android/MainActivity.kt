package com.example.githubusersloader.android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubusersloader.android.ui.MainFragment

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigationHost(navigationController = rememberNavController())
        }
    }
}

@Composable
fun MainNavigationHost(navigationController: NavHostController) {
    NavHost(navController = navigationController, startDestination = "main") {
        composable(route = "main") {
            MainFragment(onNavigateToDetails = { navigationController.navigate(route = "details") })
        }

        composable(route = "details") {

        }
    }
}
