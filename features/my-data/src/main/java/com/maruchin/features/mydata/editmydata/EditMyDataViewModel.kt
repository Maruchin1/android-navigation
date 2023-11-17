package com.maruchin.features.mydata.editmydata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class EditMyDataViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditMyDataUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadUserData()
    }

    fun submitChange(
        firstName: String,
        lastName: String,
        email: String,
        phoneNumber: String
    ) = viewModelScope.launch {
        userRepository.updatePersonalData(
            firstName = firstName,
            lastName = lastName,
            email = email,
            phoneNumber = phoneNumber,
        )
        _uiState.update {
            it.copy(isSaved = true)
        }
    }

    private fun loadUserData() = viewModelScope.launch {
        val loggedUser = userRepository.get().first() as? User.LoggedIn ?: return@launch
        _uiState.update {
            it.copy(
                firstName = loggedUser.firstName,
                lastName = loggedUser.lastName,
                email = loggedUser.email,
                phoneNumber = loggedUser.phoneNumber,
            )
        }
    }
}