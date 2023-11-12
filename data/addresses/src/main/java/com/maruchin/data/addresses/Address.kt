package com.maruchin.data.addresses

data class Address(
    val id: AddressId,
    val firstName: String,
    val lastName: String,
    val street: String,
    val house: String,
    val apartment: String?,
    val postalCode: String,
    val city: String,
)

fun Address.fullName() = "$firstName $lastName"

fun Address.firstLine() = "$street $house${apartment?.let { "/$it" } ?: ""}"

fun Address.secondLine() = "$postalCode $city"

@JvmInline
value class AddressId(val value: String)
