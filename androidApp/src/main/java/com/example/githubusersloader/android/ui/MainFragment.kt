package com.example.githubusersloader.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.githubusersloader.android.MainViewModel
import com.example.githubusersloader.android.State
import comexampleapplicationdatabase.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainFragment(
    viewModel: MainViewModel = koinViewModel(),
    navigationController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when(val state = viewModel.uiState.collectAsState().value){
            is State.Loading -> Loader()
            is State.Loaded -> MyComposeList(
                tasks = state.data,
                navigationController = navigationController
            )
            is State.Error-> ErrorView(errorText = state.message)
        }
    }
}

@Composable
fun Loader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MyComposeList(
    tasks: List<User>,
    navigationController: NavHostController
) {
    LazyColumn(
        modifier = Modifier.padding(Dp(10f), Dp(5f))
    ) {
        items(tasks) { task ->
            ListItem(task = task, navigationController = navigationController)
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Composable
fun ListItem(
    task: User,
    navigationController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .clickable(onClick = {navigationController.navigate("details/${task.id}")})
    ) {
        Text(text = task.userName?: "", fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ErrorView(errorText: String) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxWidth()
) {
    Text(text = errorText, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
}