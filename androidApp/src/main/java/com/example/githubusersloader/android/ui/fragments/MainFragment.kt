package com.example.githubusersloader.android.ui.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.githubusersloader.android.NavigationRoutes
import com.example.githubusersloader.android.presentation.MainViewModel
import com.example.githubusersloader.android.R
import com.example.githubusersloader.android.Resources
import com.example.githubusersloader.android.State
import com.example.githubusersloader.android.ui.components.ErrorView
import com.example.githubusersloader.android.ui.components.UserInfoCard
import comexampleapplicationdatabase.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainFragment(
    viewModel: MainViewModel = koinViewModel(),
    navigationController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (val state = viewModel.uiState.collectAsState().value) {
            is State.Loading -> Loader()
            is State.Loaded -> GithubUsersList(
                users = state.data,
                navigationController = navigationController
            )

            is State.Error -> ErrorView(errorText = state.message)
        }
    }
}

@Composable
fun Loader() =
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }

@Composable
fun GithubUsersList(
    users: List<User>,
    navigationController: NavHostController
) {
    val paddingSmall = Resources.convertPadding(R.dimen.padding_small)
    LazyColumn(
        modifier = Modifier.padding(paddingSmall, Resources.paddingMedium())
    ) {
        items(users) { user ->
            UserInfoCard(
                user = user,
                onClickAction = {
                    navigationController.navigate("${NavigationRoutes.DETAILS_ROUTE}/${user.id}")
                }
            )

            Spacer(
                modifier = Modifier.height(paddingSmall)
            )
        }
    }
}