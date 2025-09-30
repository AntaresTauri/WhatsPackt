package com.antares.chat.domain.usecases

import com.antares.chat.domain.IMessagesRepository
import com.antares.chat.domain.models.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrieveMessages @Inject constructor(
    private val repository: IMessagesRepository
) {
    suspend operator fun invoke(chatId: String, userId: String): Flow<Message> {
        return repository.getMessages(chatId = chatId, userId = userId)
    }
}