package com.amoferreira.auth.domain

import com.amoferreira.core.domain.util.DataError
import com.amoferreira.core.domain.util.EmptyDataResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyDataResult<DataError.Network>
}