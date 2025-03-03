package com.amoferreira.auth.domain

import io.github.serpro69.kfaker.Faker
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class PasswordValidationStateTest {
    private val faker = Faker()

    @Test
    fun `when password has no min length, then password should not be valid`() {
        // Arrange
        val sut = PasswordValidationState(
            hasMinimalLength = false,
            hasNumber = true,
            hasLowerCaseCharacter = true,
            hasUpperCaseCharacter = true,
        )

        // Assert
        assertFalse(sut.isValidPassword)
    }

    @Test
    fun `when password has no digit, then password should not be valid`() {
        // Arrange
        val sut = PasswordValidationState(
            hasMinimalLength = true,
            hasNumber = false,
            hasLowerCaseCharacter = true,
            hasUpperCaseCharacter = true,
        )

        // Assert
        assertFalse(sut.isValidPassword)
    }

    @Test
    fun `when password has no lowercase, then password should not be valid`() {
        // Arrange
        val sut = PasswordValidationState(
            hasMinimalLength = true,
            hasNumber = true,
            hasLowerCaseCharacter = false,
            hasUpperCaseCharacter = true,
        )

        // Assert
        assertFalse(sut.isValidPassword)
    }

    @Test
    fun `when password has all conditions met, then password should be valid`() {
        // Arrange
        val sut = PasswordValidationState(
            hasMinimalLength = true,
            hasNumber = true,
            hasLowerCaseCharacter = true,
            hasUpperCaseCharacter = true,
        )

        // Assert
        assertTrue(sut.isValidPassword)
    }

    @Test
    fun `when password has no uppercase, then password should not be valid`() {
        // Arrange
        val sut = PasswordValidationState(
            hasMinimalLength = faker.random.nextBoolean(),
            hasNumber = faker.random.nextBoolean(),
            hasLowerCaseCharacter = faker.random.nextBoolean(),
            hasUpperCaseCharacter = false,
        )

        // Assert
        assertFalse(sut.isValidPassword)
    }
}