package com.maruchin.features.mydata.myaddresses

import com.maruchin.data.addresses.Address
import com.maruchin.data.addresses.AddressId
import com.maruchin.data.addresses.firstLine
import com.maruchin.data.addresses.fullName
import com.maruchin.data.addresses.secondLine

internal data class MyAddressesUiState(
    val addresses: List<AddressUiState> = emptyList(),
) {

    companion object {

        fun fromDomain(addresses: List<Address>) = MyAddressesUiState(
            addresses = addresses.map(::AddressUiState)
        )
    }
}

internal data class AddressUiState(
    val id: AddressId,
    val fullName: String,
    val firstLine: String,
    val secondLine: String,
) {

    constructor(address: Address) : this(
        id = address.id,
        fullName = address.fullName(),
        firstLine = address.firstLine(),
        secondLine = address.secondLine()
    )
}
