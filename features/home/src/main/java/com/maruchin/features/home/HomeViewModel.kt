package com.maruchin.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    var products by mutableStateOf<Map<Category, List<Product>>>(emptyMap())
        private set

    init {
        loadProducts()
    }

    private fun loadProducts() = viewModelScope.launch {
        val categories = categoriesRepository.getAll()
        val productsFromCategories = categories.map { category ->
            async {
                productsRepository.getRecommendedForCategory(category)
            }
        }.awaitAll()
        products = categories.zip(productsFromCategories).toMap()
    }
}