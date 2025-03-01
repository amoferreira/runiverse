package com.amoferreira.auth.presentation.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amoferreira.auth.domain.PasswordValidationState
import com.amoferreira.core.presentation.designsystem.RuniverseTheme

@Preview
@Composable
fun RegisterScreenPreview() {
    RuniverseTheme {
        RegisterScreen(
            uiState = RegisterState(
                passwordValidationState = PasswordValidationState(
                    true
                ),
                isRegistering = true,
            ),
            onAction = {},
        )
    }
}