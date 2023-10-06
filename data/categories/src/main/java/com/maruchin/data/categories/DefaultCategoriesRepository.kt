package com.maruchin.data.categories

import com.maruchin.data.categories.api.CategoriesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DefaultCategoriesRepository @Inject constructor(
    private val categoriesApi: CategoriesApi,
) : CategoriesRepository {

    override suspend fun getAll(): List<Category> {
        return categoriesApi.getAll().map { Category(it) }
    }
}