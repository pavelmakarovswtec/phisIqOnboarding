package com.example.githubusersloader.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.database.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AppRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<State>(State.Loading)
    val uiState = _uiState

    init {
        loadUsersData()
    }

    private fun loadUsersData(){
        viewModelScope.launch {
            repository.getAllUsers().run {
                _uiState.value = State.Loaded(this)
            }
        }
    }
}