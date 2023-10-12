package com.maruchin.data.categories

import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    fun getAll(): Flow<List<Category>>

    fun getById(id: CategoryId): Flow<Category?>
}