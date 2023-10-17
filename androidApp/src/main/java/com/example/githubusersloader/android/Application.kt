package com.example.githubusersloader.android

import android.app.Application
import androidx.compose.runtime.Composable
import com.example.githubusersloader.android.di.appModule
import com.example.githubusersloader.android.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(androidContext = this@Application)
            modules(listOf(repositoryModule, appModule))
        }
    }
}

