package com.example.githubusersloader.android

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource

object Resources {

    @Composable
    fun imageSize() = dimensionResource(id = R.dimen.avatar_image_size) 
    @Composable
    fun paddingMedium() = convertPadding(dimensionId = R.dimen.padding_medium)
    
    @Composable
    fun convertPadding(
        @DimenRes dimensionId: Int
    ) = dimensionResource(id = dimensionId)
}