package com.adoyo.errorhandlingclass.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.errorhandlingclass.domain.AuthRepository
import com.adoyo.errorhandlingclass.domain.PasswordValidator
import com.adoyo.errorhandlingclass.domain.Result
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PasswordViewModel(
    private val passwordValidator: PasswordValidator,
    private val authRepository: AuthRepository
) : ViewModel() {
    private val eventChannel = Channel<UserEvents>()
    val events = eventChannel.receiveAsFlow()


    fun onRegisterClick(password: String) {
        when (val result = passwordValidator.validatePassword(password)) {
            is Result.Error -> {
                when (result.error) {
                    PasswordValidator.PasswordError.TOO_SHORT -> TODO()
                    PasswordValidator.PasswordError.NO_UPPERCASE -> TODO()
                    PasswordValidator.PasswordError.NO_DIGIT -> TODO()
                }
            }

            is Result.Success -> {}
        }

        viewModelScope.launch {
            when (val result = authRepository.register(password)) {
                is Result.Error -> {
                    val errorMessage = result.error.asUiText()
                    eventChannel.send(UserEvents.Error(errorMessage))
                }

                is Result.Success -> {
                    result.data
                }
            }
        }
    }
}

sealed interface UserEvents {
    data class Error(val error: UiText) : UserEvents
}