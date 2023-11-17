package com.maruchin.data.user

private const val EMAIL_FORMAT = "^[A-Za-z0-9+_.-]+@(.+)\$"

fun validateEmail(email: String): EmailValidationResult {
    return when {
        email.isEmpty() -> EmailValidationResult.EMPTY
        !email.matches(Regex(EMAIL_FORMAT)) -> EmailValidationResult.INVALID_FORMAT
        else -> EmailValidationResult.VALID
    }

}

fun isEmailValid(email: String): Boolean {
    return validateEmail(email) == EmailValidationResult.VALID
}

enum class EmailValidationResult {
    VALID, EMPTY, INVALID_FORMAT
}