package com.example.application.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubUser(
    @SerialName("login")
    val loginName: String?,

    @SerialName("avatar_url")
    val avatar: String?,

    @SerialName("url")
    val url: String?,

    @SerialName("type")
    val userType: String?
)