package com.maruchin.data.products

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val images: List<Int>,
    val categoryId: String,
    val rating: Rating,
    val isFavorite: Boolean,
)
