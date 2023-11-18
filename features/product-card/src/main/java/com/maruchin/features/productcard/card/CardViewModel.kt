package com.maruchin.features.productcard.card

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.cart.CartRepository
import com.maruchin.data.products.ProductsRepository
import com.maruchin.features.productcard.ProductCardArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository,
    private val cartRepository: CartRepository,
) : ViewModel() {

    private val args = ProductCardArgs(savedStateHandle)

    val product = productsRepository.getById(args.productId)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun addToCart() = viewModelScope.launch {
        val product = product.value ?: return@launch
        cartRepository.addProduct(product)
    }

    fun toggleIsFavorite() = viewModelScope.launch {
        val product = product.value ?: return@launch
        productsRepository.updateIsFavorite(
            id = product.id,
            isFavorite = !product.isFavorite,
        )
    }
}