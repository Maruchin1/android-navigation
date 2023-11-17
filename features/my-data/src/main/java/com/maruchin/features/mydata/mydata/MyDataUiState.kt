package com.maruchin.features.mydata.mydata

import com.maruchin.data.user.User

internal data class MyDataUiState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val isLoggedOut: Boolean = false,
) {

    constructor(user: User.LoggedIn) : this(
        firstName = user.firstName,
        lastName = user.lastName,
        email = user.email,
        phoneNumber = user.phoneNumber,
    )
}