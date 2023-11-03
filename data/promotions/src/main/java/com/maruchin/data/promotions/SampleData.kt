package com.maruchin.data.promotions

import java.net.URL

val samplePromotions = (0 until 10).map {
    Promotion(
        image = URL("https://img.freepik.com/free-psd/new-collection-fashion-sale-web-banner-template_120329-1507.jpg"),
        title = "Lorem ipsum dolor sit amet",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
        promoCode = PromoCode("PROMO$it")
    )
}
