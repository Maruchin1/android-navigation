package com.maruchin.features.mydata.editmydata

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.PersonalData
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class EditMyDataViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    val personalData = userRepository.get()
        .filterIsInstance<User.LoggedIn>()
        .map { it.personalData }
        .take(1)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    var isSaved: Boolean by mutableStateOf(false)
        private set

    fun submitChange(personalData: PersonalData) = viewModelScope.launch {
        userRepository.updatePersonalData(personalData)
        isSaved = true
    }
}