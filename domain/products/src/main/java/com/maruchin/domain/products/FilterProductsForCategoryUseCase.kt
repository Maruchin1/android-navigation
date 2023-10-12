package com.maruchin.domain.products

import com.maruchin.data.categories.CategoryId
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductFiltersRepository
import com.maruchin.data.products.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class FilterProductsForCategoryUseCase @Inject constructor(
    private val productFiltersRepository: ProductFiltersRepository,
    private val productsRepository: ProductsRepository,
) {

    operator fun invoke(categoryId: CategoryId): Flow<List<Product>> {
        return productFiltersRepository.get()
            .flatMapLatest { productsRepository.getForCategory(categoryId, it) }
    }
}