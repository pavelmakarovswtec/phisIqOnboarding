package com.example.githubusersloader

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform