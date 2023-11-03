package com.maruchin.data.promotions

import java.net.URL

data class Promotion(
    val id: PromotionId,
    val image: URL,
    val title: String,
    val description: String,
    val promoCode: PromoCode
)

@JvmInline
value class PromotionId(val value: String)
