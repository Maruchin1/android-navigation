package com.maruchin.features.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.products.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class FavoritesViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    val uiState = productsRepository.getFavorites()
        .map(::createFavoritesUiState)
        .stateIn(viewModelScope, SharingStarted.Lazily, FavoritesUiState())
}