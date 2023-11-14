package com.maruchin.features.home

import com.maruchin.data.categories.Category
import com.maruchin.data.categories.CategoryId
import com.maruchin.data.products.Product
import com.maruchin.data.products.ProductId

internal data class HomeUiState(
    val products: List<CategoryUiState> = emptyList(),
    val canLogin: Boolean = false,
)

internal data class CategoryUiState(
    val id: CategoryId,
    val name: String,
    val products: List<ProductUiState>
)

internal data class ProductUiState(
    val id: ProductId,
    val image: Int,
    val name: String,
    val price: Double,
    val isFavorite: Boolean,
)

internal fun createHomeUiState(
    products: Map<Category, List<Product>>,
    canLogin: Boolean
) = HomeUiState(
    products = products.map { createCategoryUiState(it.key, it.value) },
    canLogin = canLogin,
)

internal fun createCategoryUiState(category: Category, products: List<Product>) = CategoryUiState(
    id = category.id,
    name = category.name,
    products = products.map { createProductUiState(it) }
)

internal fun createProductUiState(product: Product) = ProductUiState(
    id = product.id,
    image = product.images.first(),
    name = product.name,
    price = product.price.toDouble(),
    isFavorite = product.isFavorite,
)
