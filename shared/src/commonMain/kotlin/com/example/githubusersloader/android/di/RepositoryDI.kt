package com.example.githubusersloader.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.application.database.AppDatabase
import com.example.application.database.AppRepository
import com.example.application.database.DatabaseDriverFactory
import com.example.application.database.InternalStorage
import com.example.application.network.ExternalDatasource
import org.koin.dsl.module

val repositoryModule = module {
    single<SqlDriver> { DatabaseDriverFactory(context = get()).createDriver() }
    single<AppDatabase> { AppDatabase(driver = get()) }
    single<InternalStorage>{ InternalStorage(database = get()) }
    single<ExternalDatasource> { ExternalDatasource() }
    single<AppRepository> { AppRepository(internalStorage = get(), externalDatasource = get()) }
}