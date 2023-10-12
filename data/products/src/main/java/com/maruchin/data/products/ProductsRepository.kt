package com.maruchin.data.products

import com.maruchin.data.categories.CategoryId
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getForCategory(categoryId: CategoryId, filters: ProductFilters? = null): Flow<List<Product>>

    fun getRecommendedForCategory(categoryId: CategoryId): Flow<List<Product>>

    fun findByTitle(title: String): Flow<List<Product>>

    fun getById(id: ProductId): Flow<Product>

    suspend fun updateIsFavorite(id: ProductId, isFavorite: Boolean)
}