package com.maruchin.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.user.User
import com.maruchin.data.user.UserRepository
import com.maruchin.domain.products.GroupRecommendedProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val groupRecommendedProductsUseCase: GroupRecommendedProductsUseCase,
    private val userRepository: UserRepository
) : ViewModel() {

    private val products = groupRecommendedProductsUseCase()
    private val canLogin = userRepository.get().map { it is User.LoggedOut }

    val uiState = combine(products, canLogin, ::createHomeUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, HomeUiState())
}