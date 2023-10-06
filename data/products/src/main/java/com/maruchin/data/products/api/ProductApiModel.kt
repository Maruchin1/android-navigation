package com.maruchin.data.products.api

import com.maruchin.data.categories.Category
import com.maruchin.data.products.Product
import kotlinx.serialization.Serializable
import java.net.URL

@Serializable
internal data class ProductApiModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val image: String,
    val category: String,
    val rating: RatingApiModel
)

internal fun ProductApiModel.toDomainModel() = Product(
    id = id,
    title = title,
    description = description,
    price = price,
    image = URL(image),
    category = Category(category),
    rating = rating.toDomainModel(),
)
