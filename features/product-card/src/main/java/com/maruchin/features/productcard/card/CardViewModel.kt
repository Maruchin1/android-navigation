package com.maruchin.features.productcard.card

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductsRepository
import com.maruchin.features.productcard.PRODUCT_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    private val productId: Int = requireNotNull(savedStateHandle[PRODUCT_ID])

    var product by mutableStateOf<Product?>(null)
        private set

    init {
        loadProduct()
    }

    private fun loadProduct() = viewModelScope.launch {
        product = productsRepository.getById(productId)
    }
}