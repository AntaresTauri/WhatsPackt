package com.antares.domain.fcm

interface IInternalTokenRepository {
    suspend fun storeToken(userId: String, token: String)
}