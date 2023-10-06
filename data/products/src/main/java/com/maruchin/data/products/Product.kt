package com.maruchin.data.products

import com.maruchin.data.categories.Category
import java.net.URL

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val image: URL,
    val category: Category,
    val rating: Rating,
)
