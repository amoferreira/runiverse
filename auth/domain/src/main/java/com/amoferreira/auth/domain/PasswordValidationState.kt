package com.amoferreira.auth.domain

data class PasswordValidationState(
    val hasMinimalLength: Boolean = false,
    val hasNumber: Boolean = false,
    val hasLowerCaseCharacter: Boolean = false,
    val hasUpperCaseCharacter: Boolean = false,
) {
    val isValidPassword: Boolean
        get() = hasMinimalLength && hasNumber && hasLowerCaseCharacter && hasUpperCaseCharacter
}
