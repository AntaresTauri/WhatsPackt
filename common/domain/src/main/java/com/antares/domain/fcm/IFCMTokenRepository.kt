package com.antares.domain.fcm

interface IFCMTokenRepository {
    suspend fun getFCMToken(): String
}