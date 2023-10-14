package com.maruchin.features.login.changepassword

sealed interface PasswordChangeState {

    object Idle : PasswordChangeState

    object Processing : PasswordChangeState

    object LoggedIn : PasswordChangeState
}