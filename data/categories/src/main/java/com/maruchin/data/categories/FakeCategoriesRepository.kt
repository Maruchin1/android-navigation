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

    override fun getById(id: CategoryId): Flow<Category?> {
        return categories
            .map(::flattenCategories)
            .map { findCategory(it, id) }
    }

    private fun flattenCategories(categories: List<Category>): List<Category> {
        return categories.flatMap { category ->
            val subcategories = category.subcategories
            listOf(category) + flattenCategories(subcategories)
        }
    }

    private fun findCategory(categories: List<Category>, id: CategoryId): Category? {
        return categories.find { it.id == id }
    }
}