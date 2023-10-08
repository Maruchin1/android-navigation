package com.maruchin.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.products.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    val products = flow { emit(categoriesRepository.getAll()) }
        .map { categories ->
            coroutineScope {
                val productsFromCategory = categories.map { category ->
                    async { productsRepository.getRecommendedForCategory(category) }
                }.awaitAll()
                categories.zip(productsFromCategory).toMap()
            }
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyMap())
}