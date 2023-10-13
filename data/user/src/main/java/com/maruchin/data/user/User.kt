package com.maruchin.data.user

sealed interface User {

    object LoggedIn : User

    object LoggedOut : User
}