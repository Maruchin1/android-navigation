package com.maruchin.data.categories

interface CategoriesRepository {

    suspend fun getAll(): List<Category>
}