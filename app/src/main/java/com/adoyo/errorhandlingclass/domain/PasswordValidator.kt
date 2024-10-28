package com.adoyo.errorhandlingclass.domain

class PasswordValidator {
    fun validatePassword(password: String): Result<Unit, PasswordError> {
        if (password.length < 8) {
            return Result.Error(PasswordError.TOO_SHORT)
        }

        val hasUpperCase = password.any { it.isUpperCase() }
        if (!hasUpperCase) {
            return Result.Error(PasswordError.NO_UPPERCASE)
        }

        val hasDigit = password.any { it.isDigit() }
        if (!hasDigit) {
            return Result.Error(PasswordError.NO_DIGIT)
        }
        return Result.Success(Unit)
    }

    enum class PasswordError : Error {
        TOO_SHORT,
        NO_UPPERCASE,
        NO_DIGIT,
    }
}