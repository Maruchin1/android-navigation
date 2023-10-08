package com.maruchin.features.productbrowser.filters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.data.products.ProductFilters
import com.maruchin.data.products.ProductFiltersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FiltersViewModel @Inject constructor(
    private val productFiltersRepository: ProductFiltersRepository,
) : ViewModel() {

    val filters = productFiltersRepository.get()
        .stateIn(viewModelScope, SharingStarted.Lazily, ProductFilters())

    fun updateSorting(sorting: ProductFilters.Sorting) = viewModelScope.launch {
        productFiltersRepository.updateSorting(sorting)
    }

    fun updatePrice(price: ProductFilters.Price) = viewModelScope.launch {
        productFiltersRepository.updatePrice(price)
    }
}