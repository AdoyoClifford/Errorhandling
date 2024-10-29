package com.adoyo.errorhandlingclass.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.errorhandlingclass.domain.AuthRepository
import com.adoyo.errorhandlingclass.domain.DataError
import com.adoyo.errorhandlingclass.domain.PasswordValidator
import com.adoyo.errorhandlingclass.domain.Result
import kotlinx.coroutines.launch

class PasswordViewModel(
    private val passwordValidator: PasswordValidator,
    private val authRepository: AuthRepository
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
            is Result.Success -> {}
        }

     viewModelScope.launch {
         when(val result = authRepository.register(password)) {
             is Result.Error -> {
                 when(result.error) {
                     DataError.NetworkError.REQUEST_TIMEOUT -> TODO()
                     DataError.NetworkError.TOO_MANY_REQUESTS -> TODO()
                     DataError.NetworkError.NO_INTERNET_CONNECTION -> TODO()
                     DataError.NetworkError.UNKNOWN_HOST -> TODO()
                     DataError.NetworkError.UNAUTHORIZED -> TODO()
                     DataError.NetworkError.FORBIDDEN -> TODO()
                     DataError.NetworkError.NOT_FOUND -> TODO()
                     DataError.NetworkError.BAD_REQUEST -> TODO()
                 }
             }

             is Result.Success -> {result.data}
         }
     }
    }



}