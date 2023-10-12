package com.maruchin.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.products.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    val products = categoriesRepository.getAll()
        .flatMapLatest { categories ->
            categories.map { category ->
                productsRepository.getRecommendedForCategory(category.id).map { category to it }
            }.let { flows ->
                combine(flows) {
                    it.toMap()
                }
            }
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyMap())
}