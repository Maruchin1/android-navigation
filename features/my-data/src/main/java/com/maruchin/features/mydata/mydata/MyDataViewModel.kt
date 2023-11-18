package com.maruchin.features.mydata.mydata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MyDataViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    val personalData = userRepository.get()
        .filterIsInstance<User.LoggedIn>()
        .map { it.personalData }
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    val isLoggedOut = userRepository.get()
        .map { it is User.LoggedOut }
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun logout() = viewModelScope.launch {
        userRepository.logout()
    }
}