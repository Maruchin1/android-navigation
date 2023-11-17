package com.maruchin.data.addresses

data class Address(
    val id: String,
    val firstName: String,
    val lastName: String,
    val street: String,
    val house: String,
    val apartment: String?,
    val postalCode: String,
    val city: String,
)
