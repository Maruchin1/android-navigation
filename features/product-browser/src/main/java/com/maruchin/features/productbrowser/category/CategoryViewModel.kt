package com.maruchin.features.productbrowser.category

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductsRepository
import com.maruchin.features.productbrowser.CATEGORY_NAME
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CategoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    private val categoryName: String = requireNotNull(savedStateHandle[CATEGORY_NAME])

    val category = Category(categoryName)

    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    init {
        loadProducts()
    }

    private fun loadProducts() = viewModelScope.launch {
        products = productsRepository.getForCategory(category)
    }
}