package com.tanriverdi.androidretrofit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> = _users

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error


    init {
        fetchUsers()
    }


    private fun fetchUsers(){
        viewModelScope.launch {
            try {
                _users.value = RetrofitInstance.api.getUsers()
            }catch (e: Exception){
                _error.value = "Error Fetching Users: ${e.message}"
            }
        }
    }
}