package com.maruchin.data.products.internal

import com.maruchin.data.products.ProductFilters
import com.maruchin.data.products.ProductFiltersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeProductFiltersRepository @Inject constructor() : ProductFiltersRepository {

    private val productFilters = MutableStateFlow(ProductFilters())

    override fun get(): Flow<ProductFilters> {
        return productFilters
    }

    override suspend fun updateSorting(sorting: ProductFilters.Sorting) {
        productFilters.value
            .copy(sorting = sorting)
            .let { productFilters.emit(it) }
    }

    override suspend fun updatePrice(price: ProductFilters.Price) {
        productFilters.value
            .copy(price = price)
            .let { productFilters.emit(it) }
    }
}