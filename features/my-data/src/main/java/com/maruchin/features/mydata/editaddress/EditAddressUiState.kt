package com.maruchin.features.mydata.editaddress

import com.maruchin.data.addresses.Address

internal data class EditAddressUiState(
    val firstName: String = "",
    val lastName: String = "",
    val street: String = "",
    val house: String = "",
    val apartment: String = "",
    val postalCode: String = "",
    val city: String = "",
    val isSaved: Boolean = false,
) {

    constructor(address: Address) : this(
        firstName = address.firstName,
        lastName = address.lastName,
        street = address.street,
        house = address.house,
        apartment = address.apartment ?: "",
        postalCode = address.postalCode,
        city = address.city,
    )
}