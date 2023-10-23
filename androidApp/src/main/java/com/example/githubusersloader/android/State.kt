package com.example.githubusersloader.android

import com.example.application.entity.GithubUser
import comexampleapplicationdatabase.User

sealed class State<out T> {
    data object Loading : State<Nothing>()
    data class Loaded<T>(val data: T): State<T>()
    data class Error(val message: String): State<Nothing>()
}
