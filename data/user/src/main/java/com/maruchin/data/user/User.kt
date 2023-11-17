package com.maruchin.data.user

import java.net.URL

sealed interface User {

    object LoggedOut : User

    data class LoggedIn(
        val cardBarCode: URL,
        val clubLevel: ClubLevel,
        val firstName: String,
        val lastName: String,
        val email: String,
        val phoneNumber: String,
    ) : User
}
