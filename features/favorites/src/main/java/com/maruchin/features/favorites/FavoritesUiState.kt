package com.maruchin.features.favorites

import com.maruchin.data.products.Product

internal data class FavoritesUiState(
    val products: List<ProductUiState> = emptyList()
)

internal data class ProductUiState(
    val id: String,
    val image: Int,
    val name: String,
    val price: Double,
    val isFavorite: Boolean,
)

internal fun createFavoritesUiState(products: List<Product>) = FavoritesUiState(
    products = products.map(::createProductUiState)
)

internal fun createProductUiState(product: Product) = ProductUiState(
    id = product.id,
    image = product.images.first(),
    name = product.name,
    price = product.price,
    isFavorite = product.isFavorite,
)
