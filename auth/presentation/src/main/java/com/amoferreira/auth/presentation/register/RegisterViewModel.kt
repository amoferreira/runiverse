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
                state = state.copy(
                    isEmailValid = userDataValidator.isEmailValid(email.toString())
                )
            }.launchIn(viewModelScope)

        snapshotFlow { state.password.text }
            .onEach { password ->
                Timber.i("New password input: $password")
                state = state.copy(
                    passwordValidationState = userDataValidator.validatePassword(
                        password.toString()
                    )
                )
            }.launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {

    }
}