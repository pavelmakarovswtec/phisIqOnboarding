package com.example.githubusersloader.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.githubusersloader.android.Resources
import comexampleapplicationdatabase.User

@Composable
fun UserInfoCard(
    user: User,
    showFullInfo: Boolean = false,
    onClickAction: () -> Unit = {}
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(Alignment.CenterVertically)
        .padding(Resources.paddingMedium())
        .background(MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.large)
        .padding(Resources.paddingMedium())
        .clickable(onClick = onClickAction),
    verticalAlignment = Alignment.CenterVertically
) {
    AvatarImage(avatarUri = user.avatarUri)
    Column(modifier = Modifier.padding(start = Resources.paddingMedium())) {
        Text(
            text = user.userName ?: "",
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        )

        if (showFullInfo) {
            Text(
                text = user.userType ?: "",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black
            )
            Text(
                text = user.url ?: "",
                fontStyle = FontStyle.Normal
            )
        }
    }
}
