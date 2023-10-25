package com.example.githubusersloader.android

object NavigationRoutes {
    const val MAIN_ROUTE = "main"
    const val DETAILS_ROUTE = "details"
    const val DETAILS_BY_ID_ROUTE = "$DETAILS_ROUTE/{${NavigationArguments.USER_ID}}"
}

object NavigationArguments {
    const val USER_ID = "userId"
}
