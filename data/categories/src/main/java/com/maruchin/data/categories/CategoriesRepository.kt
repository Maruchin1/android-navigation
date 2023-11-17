package com.maruchin.data.categories

import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    fun getAll(): Flow<List<Category>>

    fun getRecommended(): Flow<List<Category>>

    fun getById(id: String): Flow<Category?>
}