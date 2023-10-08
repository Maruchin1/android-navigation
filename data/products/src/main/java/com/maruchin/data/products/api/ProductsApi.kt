package com.maruchin.data.products.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

private const val RECOMMENDED_LIMIT = 5

internal class ProductsApi @Inject constructor(private val client: HttpClient) {

    suspend fun getForCategory(category: String): List<ProductApiModel> {
        return client.get("/products/category/$category").body()
    }

    suspend fun getRecommendedForCategory(category: String): List<ProductApiModel> {
        return client.get("/products/category/$category?limit=$RECOMMENDED_LIMIT").body()
    }

    suspend fun findByTitle(title: String): List<ProductApiModel> {
        return client.get("/products").body<List<ProductApiModel>>().filter {
            it.title.contains(title, ignoreCase = true)
        }
    }

    suspend fun getById(id: Int): ProductApiModel {
        return client.get("/products/$id").body()
    }
}