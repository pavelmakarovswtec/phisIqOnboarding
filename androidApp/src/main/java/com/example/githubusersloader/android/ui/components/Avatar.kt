package com.example.githubusersloader.android.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.githubusersloader.android.Resources

@Composable
fun AvatarImage(avatarUri: String?) = AsyncImage(
    model = avatarUri,
    contentDescription = avatarUri,
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .size(Resources.imageSize())
        .clip(CircleShape)
)
