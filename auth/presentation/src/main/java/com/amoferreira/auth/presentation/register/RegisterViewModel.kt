package com.amoferreira.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amoferreira.auth.domain.AuthRepository
import com.amoferreira.auth.domain.UserDataValidator
import com.amoferreira.auth.presentation.R
import com.amoferreira.core.domain.util.DataError
import com.amoferreira.core.domain.util.Result
import com.amoferreira.core.presentation.ui.UiText
import com.amoferreira.core.presentation.ui.asUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class RegisterViewModel(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository,
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    private val eventChannel = Channel<RegisterEvent>()
    val events = eventChannel.receiveAsFlow()

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
        when (action) {
            RegisterAction.OnRegisterClick -> register()
            RegisterAction.OnTogglePasswordVisibilityClick -> changePasswordVisibility()
            else -> Unit
        }
    }

    private fun register() {
        viewModelScope.launch {
            state = state.copy(isRegistering = true)
            val result = authRepository.register(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString(),
            )
            state = state.copy(isRegistering = false)

            when(result) {
                is Result.Error -> {
                    if (result.error == DataError.Network.CONFLICT) {
                        eventChannel.send(
                            RegisterEvent.Error(UiText.StringResource(R.string.error_email_exists))
                        )
                    }
                    eventChannel.send(RegisterEvent.Error(result.error.asUiText()))
                }
                is Result.Success -> {
                    eventChannel.send(RegisterEvent.RegistrationSuccess)
                }
            }
        }
    }

    private fun changePasswordVisibility() {
        state = state.copy(
            isPasswordVisible = !state.isPasswordVisible
        )
    }
}