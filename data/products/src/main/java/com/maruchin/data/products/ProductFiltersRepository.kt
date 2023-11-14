package com.maruchin.data.products

import kotlinx.coroutines.flow.Flow

interface ProductFiltersRepository {

    fun get(): Flow<ProductFilters>

    suspend fun updateSorting(sorting: ProductFilters.Sorting)

    suspend fun updatePrice(price: ProductFilters.Price)
}