package com.maruchin.core.forms.addressform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.maruchin.data.addresses.Address

@Stable
class AddressFormState {

    var firstName: String by mutableStateOf("")

    var lastName: String by mutableStateOf("")

    var street: String by mutableStateOf("")

    var house: String by mutableStateOf("")

    var apartment: String by mutableStateOf("")

    var postalCode: String by mutableStateOf("")

    var city: String by mutableStateOf("")

    val isValid by derivedStateOf {
        firstName.isNotBlank() &&
                lastName.isNotBlank() &&
                street.isNotBlank() &&
                house.isNotBlank() &&
                postalCode.isNotBlank() &&
                city.isNotBlank()
    }

    var address: Address
        get() = Address(
            id = "",
            firstName = firstName,
            lastName = lastName,
            street = street,
            house = house,
            apartment = apartment,
            postalCode = postalCode,
            city = city
        )
        set(value) {
            firstName = value.firstName
            lastName = value.lastName
            street = value.street
            house = value.house
            apartment = value.apartment ?: ""
            postalCode = value.postalCode
            city = value.city
        }
}

private val addressFormSaver = listSaver(
    save = {
        listOf(
            it.firstName,
            it.lastName,
            it.street,
            it.house,
            it.apartment,
            it.postalCode,
            it.city
        )
    },
    restore = {
        AddressFormState().apply {
            firstName = it[0]
            lastName = it[1]
            street = it[2]
            house = it[3]
            apartment = it[4]
            postalCode = it[5]
            city = it[6]
        }
    }
)

@Composable
fun rememberAddressFormState(): AddressFormState {
    return rememberSaveable(saver = addressFormSaver) {
        AddressFormState()
    }
}
