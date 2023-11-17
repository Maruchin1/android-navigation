package com.maruchin.data.categories.internal

import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.categories.Category
import com.maruchin.data.categories.flatten
import com.maruchin.data.categories.sampleCategories
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

    override fun getById(id: String): Flow<Category?> {
        return categories.map { categories ->
            categories.flatten().find { it.id == id }
        }
    }
}