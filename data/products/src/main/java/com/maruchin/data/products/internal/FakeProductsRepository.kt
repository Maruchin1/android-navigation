package com.maruchin.data.products.internal

import com.maruchin.data.categories.CategoryId
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductFilters
import com.maruchin.data.products.ProductId
import com.maruchin.data.products.ProductsRepository
import com.maruchin.data.products.sampleProducts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private const val RECOMMENDED_LIMIT = 3

@Singleton
internal class FakeProductsRepository @Inject constructor() : ProductsRepository {

    private val products = MutableStateFlow(sampleProducts)

    override fun getForCategory(
        categoryId: CategoryId,
        filters: ProductFilters?
    ): Flow<List<Product>> {
        return products.map { products ->
            products
                .filter { it.categoryId == categoryId }
                .let { filters?.invoke(it) }
                ?: products
        }
    }

    override fun getRecommendedForCategory(categoryId: CategoryId): Flow<List<Product>> {
        return getForCategory(categoryId).map { products ->
            if (products.size > RECOMMENDED_LIMIT) products.take(RECOMMENDED_LIMIT)
            else products
        }
    }

    override fun getFavorites(): Flow<List<Product>> {
        return products.map { products ->
            products.filter { product ->
                product.isFavorite
            }
        }
    }

    override fun findByTitle(title: String): Flow<List<Product>> {
        return products.map { products ->
            products.filter { product ->
                product.name.contains(title, ignoreCase = true)
            }
        }
    }

    override fun getById(id: ProductId): Flow<Product> {
        return products.map { products ->
            products.find { product ->
                product.id == id
            }
        }.filterNotNull()
    }

    override suspend fun updateIsFavorite(id: ProductId, isFavorite: Boolean) {
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