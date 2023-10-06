package com.maruchin.data.categories.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

internal class CategoriesApi @Inject constructor(private val client: HttpClient) {

    suspend fun getAll(): List<String> {
        return client.get("/products/categories").body()
    }
}