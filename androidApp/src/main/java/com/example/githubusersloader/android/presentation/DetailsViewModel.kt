package com.example.githubusersloader.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.database.AppRepository
import comexampleapplicationdatabase.User
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    val userId: Long,
    val repository: AppRepository
) : ViewModel() {
    val userData: User = repository.getUser(userId)
}
