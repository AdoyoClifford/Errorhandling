package com.adoyo.errorhandlingclass.presentation

import androidx.lifecycle.ViewModel
import com.adoyo.errorhandlingclass.domain.PasswordValidator
import com.adoyo.errorhandlingclass.domain.Result

class PasswordViewModel(
    private val passwordValidator: PasswordValidator
): ViewModel() {

    fun onRegisterClick(password: String) {
        when(val result = passwordValidator.validatePassword(password)) {
            is Result.Error -> {
                when(result.error) {
                    PasswordValidator.PasswordError.TOO_SHORT -> TODO()
                    PasswordValidator.PasswordError.NO_UPPERCASE -> TODO()
                    PasswordValidator.PasswordError.NO_DIGIT -> TODO()
                }
            }
            is Result.Success -> TODO()
        }
    }
}