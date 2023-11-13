package com.maruchin.features.productcard.card

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.cart.CartRepository
import com.maruchin.data.products.ProductsRepository
import com.maruchin.features.productcard.ProductCardArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
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

    private val message = MutableStateFlow<Int?>(null)

    private val product = productsRepository.getById(args.productId)
        .filterNotNull()

    val uiState = combine(
        product,
        message,
        ::CardUiState
    ).stateIn(viewModelScope, SharingStarted.Lazily, CardUiState())

    fun addToCart() = viewModelScope.launch {
        val product = product.first()
        cartRepository.addProduct(product)
    }
}