package com.antares.chat.domain.usecases

import com.antares.chat.domain.IChatRoomRepository
import com.antares.chat.domain.models.ChatRoom
import javax.inject.Inject

class GetInitialChatRoomInformation @Inject constructor(
    private val repository: IChatRoomRepository
) {
    suspend operator fun invoke(id: String): ChatRoom {
        return repository.getInitialChatRoom(id)
    }
}