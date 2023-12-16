package com.maruchin.features.registration.birthdate

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
internal class BirthDateViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var birthDateSaved: Boolean by mutableStateOf(false)
        private set

    fun saveBirthDate(birthDate: LocalDate) = viewModelScope.launch {
        userRepository.updateBirthDate(birthDate)
        birthDateSaved = true
    }
}