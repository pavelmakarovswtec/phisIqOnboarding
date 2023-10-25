package com.example.githubusersloader.android.di

import com.example.githubusersloader.android.presentation.DetailsViewModel
import com.example.githubusersloader.android.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(repository = get()) }
    viewModel { (userId: Long) -> DetailsViewModel(userId = userId, repository = get()) }
}
