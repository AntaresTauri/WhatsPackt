package com.antares.chat.domain

import com.antares.chat.domain.models.ChatRoom

interface IChatRoomRepository {
    suspend fun getInitialChatRoom(id: String): ChatRoom
}