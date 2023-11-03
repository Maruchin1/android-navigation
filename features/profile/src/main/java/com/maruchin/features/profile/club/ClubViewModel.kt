package com.maruchin.features.profile.club

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ClubViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    val user = userRepository.get()
        .filterIsInstance<User.LoggedIn>()
        .stateIn(viewModelScope, SharingStarted.Lazily, null)
}