package com.antares.chat.domain.usecases

import com.antares.chat.domain.IMessagesRepository
import javax.inject.Inject

class DisconnectMessages @Inject constructor(
    private val repository: IMessagesRepository
) {
    suspend operator fun invoke() {
        repository.disconnect()
    }
}