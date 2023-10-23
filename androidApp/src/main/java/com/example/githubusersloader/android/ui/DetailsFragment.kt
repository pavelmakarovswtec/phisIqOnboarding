package com.example.githubusersloader.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.githubusersloader.android.DetailsViewModel
import com.example.githubusersloader.android.State
import comexampleapplicationdatabase.User
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parameterArrayOf

@Composable
fun DetailsFragment(
    userId: Long?,
    viewModel: DetailsViewModel = koinViewModel { parameterArrayOf(userId) }
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(val state = viewModel.uiState.collectAsState().value){
            is State.Loaded->{
                UserInfo(user = state.data)}
            else -> {}
        }
    }
}

@Composable
fun UserInfo(
    user: User
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.CenterVertically)
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(model = user.avatarUri, contentDescription = user.avatarUri, contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape))
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = user.userName ?: "", fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
            Text(text = user.userType ?: "", fontStyle = FontStyle.Normal, fontWeight = FontWeight.Black)
            Text(text = user.url?:"", fontStyle = FontStyle.Normal)
        }
    }
}