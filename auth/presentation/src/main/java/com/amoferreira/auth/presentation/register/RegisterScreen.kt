package com.amoferreira.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.amoferreira.auth.domain.UserDataValidator.Companion.MIN_PASSWORD_LENGTH
import com.amoferreira.auth.presentation.R
import com.amoferreira.auth.presentation.register.components.PasswordRequirement
import com.amoferreira.core.presentation.designsystem.CheckIcon
import com.amoferreira.core.presentation.designsystem.EmailIcon
import com.amoferreira.core.presentation.designsystem.Poppins
import com.amoferreira.core.presentation.designsystem.RuniverseGray
import com.amoferreira.core.presentation.designsystem.components.GradientBackground
import com.amoferreira.core.presentation.designsystem.components.RuniversePasswordTextField
import com.amoferreira.core.presentation.designsystem.components.RuniverseTextField
import com.amoferreira.core.presentation.designsystem.components.TextButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterScreen(
    uiState: RegisterState,
    onAction: (RegisterAction) -> Unit,
) {

    GradientBackground {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.create_account),
                style = MaterialTheme.typography.headlineMedium,
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = Poppins,
                        color = RuniverseGray,
                    )
                ) {
                    append(stringResource(id = R.string.already_have_an_account) + " ")
                    pushStringAnnotation(
                        tag = "clickable_text",
                        annotation = stringResource(id = R.string.login)
                    )
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = Poppins,
                        )
                    ) {
                        append(stringResource(id = R.string.login))
                    }
                }
            }
            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(
                        tag = "clickable_text",
                        start = offset,
                        end = offset,
                    ).firstOrNull()?.let {
                        onAction(RegisterAction.OnLoginClick)
                    }
                }
            )
            Spacer(modifier = Modifier.height(48.dp))
            RuniverseTextField(
                state = uiState.email,
                startIcon = EmailIcon,
                endIcon = if (uiState.isEmailValid) {
                    CheckIcon
                } else null,
                hint = stringResource(R.string.example_email),
                title = stringResource(R.string.email),
                modifier = Modifier.fillMaxWidth(),
                additionalInfo = stringResource(R.string.must_be_valid_email),
                keyboardType = KeyboardType.Email,
            )
            Spacer(modifier = Modifier.height(16.dp))
            RuniversePasswordTextField(
                state = uiState.password,
                isPasswordVisible = uiState.isPasswordVisible,
                onPasswordVisibilityToggleClick = {
                    onAction(RegisterAction.OnTogglePasswordVisibilityClick)
                },
                hint = stringResource(id = R.string.password),
                title = stringResource(id = R.string.password),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))

            PasswordRequirement(
                text = stringResource(
                    id = R.string.password_requirement_at_least_x_characters,
                    MIN_PASSWORD_LENGTH,
                ),
                isValid = uiState.passwordValidationState.hasMinimalLength,
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.password_requirement_at_least_one_number,
                ),
                isValid = uiState.passwordValidationState.hasNumber,
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.password_requirement_at_least_one_uppercase,
                ),
                isValid = uiState.passwordValidationState.hasUpperCaseCharacter,
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.password_requirement_at_least_one_lowercase,
                ),
                isValid = uiState.passwordValidationState.hasLowerCaseCharacter,
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextButton(
                text = stringResource(id = R.string.register),
                isLoading = uiState.isRegistering,
                enabled = uiState.canRegister,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onAction(RegisterAction.OnRegisterClick)
                }
            )
        }
    }
}