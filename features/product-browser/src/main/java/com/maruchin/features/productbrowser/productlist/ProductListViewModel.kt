package com.maruchin.features.productbrowser.productlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.products.ProductFiltersRepository
import com.maruchin.data.products.ProductsRepository
import com.maruchin.features.productbrowser.ProductBrowserArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combineTransform
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ProductListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val categoriesRepository: CategoriesRepository,
    private val productsRepository: ProductsRepository,
    private val productFiltersRepository: ProductFiltersRepository,
) : ViewModel() {

    private val args = ProductBrowserArgs(savedStateHandle)

    val category = categoriesRepository.getById(args.categoryId)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    val products = combineTransform(
        category.filterNotNull(),
        productFiltersRepository.get(),
    ) { category, filters ->
        emitAll(productsRepository.getForCategory(category.id, filters))
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}