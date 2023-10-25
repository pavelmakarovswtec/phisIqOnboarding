package com.example.githubusersloader.android.presentation

import androidx.lifecycle.ViewModel
import com.example.application.database.AppRepository
import comexampleapplicationdatabase.User

class DetailsViewModel(
    val userId: Long,
    val repository: AppRepository
) : ViewModel() {
    val userData: User = repository.getUser(userId)
}
