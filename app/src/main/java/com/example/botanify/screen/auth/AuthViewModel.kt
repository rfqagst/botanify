package com.example.botanify.screen.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.botanify.data.repository.firebase.AuthRepository
import com.example.botanify.utils.Resource
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _signupFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Resource<FirebaseUser>?> = _signupFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUserFirebase

    fun login(email: String, password: String) = viewModelScope.launch {
        val result = repository.loginFirebase(email, password)
        _loginFlow.value = result
    }

    fun signUp(name: String, email: String, password: String) = viewModelScope.launch {
        val result = repository.signupFirebase(email, password, name)
        _signupFlow.value = result
        Log.d("AuthViewModel", "$email,signUp: ${result.message}")
    }

}