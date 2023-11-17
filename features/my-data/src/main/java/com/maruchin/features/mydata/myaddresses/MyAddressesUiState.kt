package com.maruchin.features.mydata.myaddresses

import com.maruchin.data.addresses.Address

internal data class MyAddressesUiState(
    val addresses: List<Address> = emptyList(),
)
