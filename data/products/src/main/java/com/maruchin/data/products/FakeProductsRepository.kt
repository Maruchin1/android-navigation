package com.maruchin.data.products

import com.maruchin.data.categories.CategoryId
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private const val RECOMMENDED_LIMIT = 3

@Singleton
internal class FakeProductsRepository @Inject constructor() : ProductsRepository {
    private val products = MutableStateFlow<List<Product>>(emptyList())

    override fun getForCategory(
        categoryId: CategoryId,
        filters: ProductFilters?
    ): Flow<List<Product>> {
        return products.map { products ->
            products.filter { product ->
                product.category.id == categoryId
            }
        }
    }

    override fun getRecommendedForCategory(categoryId: CategoryId): Flow<List<Product>> {
        return getForCategory(categoryId).map { products ->
            products.take(RECOMMENDED_LIMIT)
        }
    }

    override fun findByTitle(title: String): Flow<List<Product>> {
        return products.map { products ->
            products.filter { product ->
                product.title.contains(title, ignoreCase = true)
            }
        }
    }

    override fun getById(id: Int): Flow<Product> {
        return products.map { products ->
            products.find { product ->
                product.id == id
            }
        }.filterNotNull()
    }

    override suspend fun updateIsFavorite(id: Int, isFavorite: Boolean) {
        val updatedProducts = products.value.map { product ->
            if (product.id == id) {
                product.copy(isFavorite = isFavorite)
            } else {
                product
            }
        }
        products.emit(updatedProducts)
    }
}