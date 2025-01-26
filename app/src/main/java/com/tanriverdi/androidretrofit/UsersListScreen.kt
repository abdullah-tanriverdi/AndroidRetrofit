package com.tanriverdi.androidretrofit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@JvmOverloads
@Composable
fun UsersListScreen(userViewModel: UserViewModel = viewModel()) {

 val users = userViewModel.users.value
 val error = userViewModel.error.value

 if (error!= null){
     Text(text = error, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(16.dp))

 }else{
     LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
         items(users) {
             user ->
             UserCard(user = user)
         }
     }
 }
}


@Composable
fun UserCard(user: User){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${user.name}" , style = MaterialTheme.typography.bodyMedium)
            Text(text = "Email: ${user.email}" , style = MaterialTheme.typography.bodyMedium)
        }
    }
}