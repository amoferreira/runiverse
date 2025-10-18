package com.amoferreira.auth.data

import com.amoferreira.auth.domain.AuthRepository
import com.amoferreira.core.data.networking.post
import com.amoferreira.core.domain.util.DataError
import com.amoferreira.core.domain.util.EmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
): AuthRepository {

    override suspend fun register(
        email: String,
        password: String,
    ): EmptyDataResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password,
            )
        )
    }
}