package com.maruchin.data.products

import com.maruchin.data.categories.Category

interface ProductsRepository {

    suspend fun getForCategory(category: Category): List<Product>

    suspend fun getRecommendedForCategory(category: Category): List<Product>

    suspend fun findByTitle(title: String): List<Product>

    suspend fun getById(id: Int): Product
}