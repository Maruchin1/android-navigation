package com.maruchin.data.products

import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getForCategory(categoryId: String, filters: ProductFilters? = null): Flow<List<Product>>

    fun getRecommendedForCategory(categoryId: String): Flow<List<Product>>

    fun getFavorites(): Flow<List<Product>>

    fun findByTitle(title: String): Flow<List<Product>>

    fun getById(id: String): Flow<Product>

    suspend fun updateIsFavorite(id: String, isFavorite: Boolean)
}