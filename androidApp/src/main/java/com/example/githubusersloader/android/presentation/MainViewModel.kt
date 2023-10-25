package com.example.githubusersloader.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.database.AppRepository
import com.example.githubusersloader.android.State
import comexampleapplicationdatabase.User
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AppRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<State<List<User>>>(State.Loading)
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.value = State.Error(throwable.message ?: "")
    }

    init {
        loadUsersData()
    }

    private fun loadUsersData() {
        viewModelScope.launch(exceptionHandler) {
            val userInfoDeferredResult = viewModelScope.async { repository.getAllUsers() }
            _uiState.value = State.Loaded(data = userInfoDeferredResult.await())
        }
    }
}
