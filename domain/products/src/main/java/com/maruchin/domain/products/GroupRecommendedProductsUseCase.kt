package com.maruchin.domain.products

import com.maruchin.data.categories.CategoriesRepository
import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GroupRecommendedProductsUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
    private val productsRepository: ProductsRepository,
) {

    operator fun invoke(): Flow<Map<Category, List<Product>>> {
        return categoriesRepository.getRecommended()
            .flatMapLatest { categories ->
                val products = categories.map { category ->
                    productsRepository.getRecommendedForCategory(category.id)
                        .map { category to it }
                }
                combine(products) { it.toMap() }
            }
    }
}