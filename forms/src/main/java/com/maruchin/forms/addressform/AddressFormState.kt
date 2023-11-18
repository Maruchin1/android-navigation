package com.maruchin.forms.addressform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.maruchin.forms.textfield.TextFieldState
import com.maruchin.forms.textfield.rememberTextFieldState
import com.maruchin.data.addresses.Address

@Stable
class AddressFormState(
    val firstName: TextFieldState,
    val lastName: TextFieldState,
    val street: TextFieldState,
    val house: TextFieldState,
    val apartment: TextFieldState,
    val postalCode: TextFieldState,
    val city: TextFieldState,
) {

    val isValid by derivedStateOf {
        firstName.isValid &&
                lastName.isValid &&
                street.isValid &&
                house.isValid &&
                apartment.isValid &&
                postalCode.isValid &&
                city.isValid
    }

    var address: Address
        get() = Address(
            id = "",
            firstName = firstName.value,
            lastName = lastName.value,
            street = street.value,
            house = house.value,
            apartment = apartment.value,
            postalCode = postalCode.value,
            city = city.value
        )
        set(value) {
            firstName.value = value.firstName
            lastName.value = value.lastName
            street.value = value.street
            house.value = value.house
            apartment.value = value.apartment ?: ""
            postalCode.value = value.postalCode
            city.value = value.city
        }
}

@Composable
fun rememberAddressFormState(): AddressFormState {
    val firstName = rememberTextFieldState()
    val lastName = rememberTextFieldState()
    val street = rememberTextFieldState()
    val house = rememberTextFieldState()
    val apartment = rememberTextFieldState()
    val postalCode = rememberTextFieldState()
    val city = rememberTextFieldState()

    return remember(firstName, lastName, street, house, apartment, postalCode, city) {
        AddressFormState(firstName, lastName, street, house, apartment, postalCode, city)
    }
}
