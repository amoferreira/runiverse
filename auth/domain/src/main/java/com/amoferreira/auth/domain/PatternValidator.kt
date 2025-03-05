package com.amoferreira.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}