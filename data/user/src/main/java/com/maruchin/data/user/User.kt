package com.maruchin.data.user

sealed interface User {

    object LoggedOut : User

    data class LoggedIn(
        val clubData: ClubData,
        val personalData: PersonalData,
    ) : User
}
