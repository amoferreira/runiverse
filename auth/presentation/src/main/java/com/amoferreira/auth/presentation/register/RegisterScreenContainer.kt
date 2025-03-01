package com.amoferreira.auth.presentation.register

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreenContainer(
    onSignInClick: () -> Unit,
    onSuccessfulRegistration: () -> Unit,
    viewModel: RegisterViewModel = koinViewModel(),
) {
    RegisterScreen(
        uiState = viewModel.state,
        onAction = viewModel::onAction,
    )
}