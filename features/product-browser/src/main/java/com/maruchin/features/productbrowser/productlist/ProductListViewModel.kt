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
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ProductListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val categoriesRepository: CategoriesRepository,
    private val productFiltersRepository: ProductFiltersRepository,
    private val productsRepository: ProductsRepository,
) : ViewModel() {

    private val args = ProductBrowserArgs(savedStateHandle)

    val category = categoriesRepository.getById(args.categoryId)
        .stateIn(viewModelScope, SharingStarted.Lazily, null)

    val products = productFiltersRepository.get()
        .flatMapLatest { productsRepository.getForCategory(args.categoryId, it) }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}