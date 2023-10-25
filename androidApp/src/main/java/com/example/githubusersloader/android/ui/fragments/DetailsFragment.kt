package com.example.githubusersloader.android.ui.fragments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.githubusersloader.android.presentation.DetailsViewModel
import com.example.githubusersloader.android.ui.components.UserInfoCard
import comexampleapplicationdatabase.User
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parameterArrayOf

@Composable
fun DetailsFragment(
    userId: Long?,
    viewModel: DetailsViewModel = koinViewModel { parameterArrayOf(userId) }
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        UserInfo(user = viewModel.userData)
    }
}

@Composable
fun UserInfo(
    user: User
) = UserInfoCard(
    user = user,
    showFullInfo = true)

