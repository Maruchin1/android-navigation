package com.maruchin.data.products

import com.maruchin.data.categories.Category
import com.maruchin.data.products.api.ProductsApi
import com.maruchin.data.products.api.toDomainModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DefaultProductsRepository @Inject constructor(
    private val productsApi: ProductsApi
) : ProductsRepository {

    override suspend fun getForCategory(category: Category): List<Product> {
        return productsApi.getForCategory(category.name).map { it.toDomainModel() }
    }

    override suspend fun getRecommendedForCategory(category: Category): List<Product> {
        return productsApi.getRecommendedForCategory(category.name).map { it.toDomainModel() }
    }

    override suspend fun findByTitle(title: String): List<Product> {
        return productsApi.findByTitle(title).map { it.toDomainModel() }
    }

    override suspend fun getById(id: Int): Product {
        return productsApi.getById(id).toDomainModel()
    }
}