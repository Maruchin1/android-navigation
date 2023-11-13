package com.maruchin.features.cart.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.cart.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository,
) : ViewModel() {

    val uiState = cartRepository.get()
        .map(::CartUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, CartUiState())
}