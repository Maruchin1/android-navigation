package com.maruchin.data.products.api

import com.maruchin.data.products.Rating
import kotlinx.serialization.Serializable

@Serializable
internal data class RatingApiModel(val rate: Float, val count: Int)

internal fun RatingApiModel.toDomainModel() = Rating(rate, count)
