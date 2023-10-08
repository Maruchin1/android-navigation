package com.maruchin.features.productcard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ProductCardViewModel @Inject constructor(
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