package com.example.githubusersloader.android

import androidx.lifecycle.ViewModel
import com.example.application.database.AppRepository
import comexampleapplicationdatabase.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailsViewModel(
    val userId: Long,
    val repository: AppRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<State<User>>(State.Loading)
    val uiState = _uiState.asStateFlow()

    init{
        loadUserInfo()
    }

    private fun loadUserInfo(){
        _uiState.value = State.Loaded(repository.getUser(userId))
    }
}