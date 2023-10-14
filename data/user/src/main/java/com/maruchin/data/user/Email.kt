package com.maruchin.data.user

@JvmInline
value class Email(val value: String) {

    companion object {
        private const val FORMAT = "^[A-Za-z0-9+_.-]+@(.+)\$"

        fun validate(value: String): ValidationResult {
            return when {
                value.isEmpty() -> ValidationResult.EMPTY
                !value.matches(Regex(FORMAT)) -> ValidationResult.INVALID_FORMAT
                else -> ValidationResult.VALID
            }
        }

        fun isValid(value: String): Boolean {
            return validate(value) == ValidationResult.VALID
        }
    }

    enum class ValidationResult {
        VALID, EMPTY, INVALID_FORMAT
    }
}