package com.maruchin.data.user

@JvmInline
value class Password(val value: String) {

    companion object {

        fun validate(value: String): ValidationResult {
            return when {
                value.isEmpty() -> ValidationResult.EMPTY
                else -> ValidationResult.VALID
            }
        }
    }

    enum class ValidationResult {
        VALID, EMPTY
    }
}