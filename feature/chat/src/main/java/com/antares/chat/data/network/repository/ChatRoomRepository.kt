package com.antares.chat.data.network.repository

import com.antares.chat.data.network.datasource.ChatRoomDataSource
import com.antares.chat.domain.IChatRoomRepository
import com.antares.chat.domain.models.ChatRoom
import javax.inject.Inject

class ChatRoomRepository @Inject constructor(
    private val dataSource: ChatRoomDataSource
) : IChatRoomRepository {

    override suspend fun getInitialChatRoom(id: String): ChatRoom {
        val chatRoomApiModel = dataSource.getInitialChatRoom(id)
        return chatRoomApiModel.toDomain()
    }
}