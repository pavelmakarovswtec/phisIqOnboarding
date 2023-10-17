package com.example.application.database

import app.cash.sqldelight.db.SqlDriver


expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}