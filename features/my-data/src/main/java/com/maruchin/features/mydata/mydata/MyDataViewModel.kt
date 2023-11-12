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
import javax.inject.Inject

@HiltViewModel
internal class MyDataViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    val uiState = userRepository.get()
        .filterIsInstance<User.LoggedIn>()
        .map(::MyDataUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, MyDataUiState())
}