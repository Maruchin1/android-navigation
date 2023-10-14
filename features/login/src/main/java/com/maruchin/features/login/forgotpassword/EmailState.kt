package com.maruchin.features.login.forgotpassword

internal sealed interface EmailState {

    object Idle : EmailState

    object Sending : EmailState

    object Sent : EmailState
}