package com.amoferreira.auth.domain

import io.github.serpro69.kfaker.Faker
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class UserDataValidatorTest {
    private lateinit var patternValidator: PatternValidator
    private lateinit var sut: UserDataValidator
    private val faker = Faker()

    @Before
    fun setup() {
        patternValidator = mockk()
        sut = UserDataValidator(patternValidator)
    }

    @Test
    fun `when password has not min length, then validatePassword should state with hasMinLength false`() {
        // Arrange
        val password = faker.random.randomString(1, 8)

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertFalse(result.hasMinimalLength)
    }

    @Test
    fun `when password has min length, then validatePassword should state with hasMinLength true`() {
        // Arrange
        val password = faker.random.randomString(9, 20)

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertTrue(result.hasMinimalLength)
    }

    @Test
    fun `when password has no digit, then validatePassword should state with hasNumber false`() {
        // Arrange
        val password = faker.random.randomString(
            numericalChars = false
        )

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertFalse(result.hasNumber)
    }

    @Test
    fun `when password has digit, then validatePassword should state with hasNumber true`() {
        // Arrange
        val password = faker.random.randomString(
            numericalChars = true
        )

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertTrue(result.hasNumber)
    }

    @Test
    fun `when password has no lowercase, then validatePassword should state with hasLowerCase false`() {
        // Arrange
        val password = faker.random.randomString().uppercase()

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertFalse(result.hasLowerCaseCharacter)
    }

    @Test
    fun `when password has lowercase, then validatePassword should state with hasLowerCase true`() {
        // Arrange
        val password = faker.random.randomString().lowercase()

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertTrue(result.hasLowerCaseCharacter)
    }

    @Test
    fun `when password has no uppercase, then validatePassword should state with haUpperCase false`() {
        // Arrange
        val password = faker.random.randomString().lowercase()

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertFalse(result.hasUpperCaseCharacter)
    }

    @Test
    fun `when password has uppercase, then validatePassword should state with hasUpperCase true`() {
        // Arrange
        val password = faker.random.randomString().uppercase()

        // Act
        val result = sut.validatePassword(password)

        // Assert
        assertTrue(result.hasUpperCaseCharacter)
    }

    @Test
    fun `when isEmailValid(), then should return value from patter validator`() {
        // Arrange
        val expectedResult = faker.random.nextBoolean()
        every { patternValidator.matches(any()) } returns expectedResult

        // Act
        val result = sut.isEmailValid(faker.random.randomString())

        // Assert
        assertEquals(expectedResult, result)
    }
}