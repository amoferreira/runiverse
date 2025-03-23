package com.amoferreira.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amoferreira.auth.domain.UserDataValidator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

class RegisterViewModel(
    private val userDataValidator: UserDataValidator,
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    init {
        snapshotFlow { state.email.text }
            .onEach { email ->
                Timber.i("New email input: $email")
                val isEmailValid = userDataValidator.isEmailValid(email.toString())
                state = state.copy(
                    isEmailValid = isEmailValid,
                    canRegister = isEmailValid && state.passwordValidationState.isValidPassword &&
                            !state.isRegistering,
                )
            }.launchIn(viewModelScope)

        snapshotFlow { state.password.text }
            .onEach { password ->
                Timber.i("New password input: $password")
                val passwordState = userDataValidator.validatePassword(password.toString())
                state = state.copy(
                    passwordValidationState = passwordState,
                    canRegister = passwordState.isValidPassword && state.isEmailValid &&
                            !state.isRegistering,
                )
            }.launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {

    }
}