package com.maruchin.data.products

import com.maruchin.data.categories.CategoryId
import java.net.URL

data class Product(
    val id: ProductId,
    val name: String,
    val description: String,
    val price: Float,
    val images: List<URL>,
    val categoryId: CategoryId,
    val rating: Rating,
    val isFavorite: Boolean,
)

@JvmInline
value class ProductId(val value: String)
