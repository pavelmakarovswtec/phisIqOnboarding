package com.example.githubusersloader.android

import com.example.application.entity.GithubUser
import comexampleapplicationdatabase.User

sealed class State {
    data object Loading: State()
    class Loaded(val data: List<User>): State()
    class Error(message: String): State()
}
