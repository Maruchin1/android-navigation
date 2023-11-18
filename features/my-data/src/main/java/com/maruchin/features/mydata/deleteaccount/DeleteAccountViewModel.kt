package com.maruchin.features.mydata.deleteaccount

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DeleteAccountViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    var isDeleted by mutableStateOf(false)
        private set

    fun deleteAccount() = viewModelScope.launch {
        userRepository.deleteAccount()
        isDeleted = true
    }
}