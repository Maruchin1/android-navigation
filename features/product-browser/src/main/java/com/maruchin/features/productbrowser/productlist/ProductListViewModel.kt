package com.maruchin.features.productbrowser.productlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.categories.Category
import com.maruchin.data.products.ProductFiltersRepository
import com.maruchin.data.products.ProductsRepository
import com.maruchin.features.productbrowser.ProductBrowserArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class ProductListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productsRepository: ProductsRepository,
    private val productFiltersRepository: ProductFiltersRepository,
) : ViewModel() {

    private val args = ProductBrowserArgs(savedStateHandle)

    val category = Category(args.categoryName)

    val products = productFiltersRepository.get()
        .map { productsRepository.getForCategory(category, it) }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}