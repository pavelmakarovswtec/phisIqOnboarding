package com.example.application.database

import com.example.application.entity.GithubUser
import com.example.application.network.ExternalDatasource
import comexampleapplicationdatabase.User

class AppRepository(
    private val internalStorage: InternalStorage,
    private val externalDatasource: ExternalDatasource
) {
    suspend fun getAllUsers(): List<User> {
        externalDatasource.getAllUsers().also {
            internalStorage.createUsers(it)
        }
        return internalStorage.getAllUsers().executeAsList()
    }
}