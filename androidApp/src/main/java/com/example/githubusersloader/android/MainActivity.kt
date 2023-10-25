package com.example.githubusersloader.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubusersloader.android.ui.DetailsFragment
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
    NavHost(navController = navigationController, startDestination = NavigationRoutes.MAIN_ROUTE) {
        composable(route = NavigationRoutes.MAIN_ROUTE) {
            MainFragment(navigationController = navigationController)
        }

        composable(
            route = NavigationRoutes.DETAILS_BY_ID_ROUTE,
            arguments = listOf(navArgument(NavigationArguments.USER_ID) { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            DetailsFragment(
                userId = arguments.getLong(NavigationArguments.USER_ID)
            )
        }
    }
}
