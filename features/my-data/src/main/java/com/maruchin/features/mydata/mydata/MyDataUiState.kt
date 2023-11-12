package com.maruchin.features.mydata.mydata

import com.maruchin.data.user.User
import com.maruchin.data.user.fullName

internal data class MyDataUiState(
    val fullName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val isLoggedOut: Boolean = false,
) {

    constructor(user: User.LoggedIn) : this(
        fullName = user.fullName(),
        email = user.email.value,
        phoneNumber = user.phoneNumber.value,
    )
}