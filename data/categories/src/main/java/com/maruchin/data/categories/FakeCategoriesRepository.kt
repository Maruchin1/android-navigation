package com.maruchin.data.categories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class FakeCategoriesRepository @Inject constructor() : CategoriesRepository {

    private val categories = MutableStateFlow(sampleCategories)

    override fun getAll(): Flow<List<Category>> {
        return categories
    }

    override fun getRecommended(): Flow<List<Category>> {
        return categories.map { categories ->
            categories.flatten().filter { it.isFinal }
        }
    }

    override fun getById(id: CategoryId): Flow<Category?> {
        return categories.map { categories ->
            categories.flatten().find { it.id == id }
        }
    }
}