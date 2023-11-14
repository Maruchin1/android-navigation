package com.maruchin.data.deliveries

val sampleDeliveries = listOf(
    Delivery(
        id = DeliveryId("1"),
        logo = R.drawable.dhl_logo,
        name = "DHL",
        price = 5f,
    ),
    Delivery(
        id = DeliveryId("2"),
        logo = R.drawable.gls_logo,
        name = "GLS",
        price = 7f,
    ),
    Delivery(
        id = DeliveryId("3"),
        logo = R.drawable.ups_logo,
        name = "UPS",
        price = 3f,
    ),
)