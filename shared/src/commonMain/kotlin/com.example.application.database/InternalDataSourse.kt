package com.example.application.database

import com.example.application.entity.GithubUser
import comexampleapplicationdatabase.User

class InternalStorage(database: AppDatabase) {
    private val dbQuery = database.appDatabaseQueries

    fun getAllUsers() = dbQuery.getAllUsersInfo()

    fun createUsers(users: List<GithubUser>) = dbQuery.transaction {
        users.forEach {user->
            insertUser(user)
        }
    }

    private fun insertUser(user: GithubUser) = dbQuery.insertUser(
       createUserInternalData(user)
    )

    private fun createUserInternalData(user: GithubUser) = User(
        userName = user.loginName,
        avatarUri = user.avatar,
        url = user.url,
        userType = user.userType
    )
}