package com.antares.chat.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.antares.chat.ui.model.Message
import com.antares.chat.ui.model.MessageContent
import com.antares.framework.ui.Avatar

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isMine) Arrangement.End else Arrangement.Start
    ) {
        if (!message.isMine) {
            Avatar(
                imageUrl = message.senderAvatar,
                size = 40.dp,
                contentDescription = "${message.senderName}'s avatar"
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Column {
            if (message.isMine) {
                Spacer(modifier = Modifier.height(8.dp))
            } else {
                Text(
                    text = message.senderName,
                    fontWeight = FontWeight.Bold
                )
            }
            when (val content = message.messageContent) {
                is MessageContent.TextMessage -> {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = if (message.isMine) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.secondary
                    ) {
                        Text(
                            text = content.message,
                            modifier = Modifier.padding(8.dp),
                            color = if (message.isMine) MaterialTheme.colorScheme.onPrimary else Color.White
                        )
                    }
                }
                is MessageContent.ImageMessage -> {
                    AsyncImage(
                        model = content.imageUrl,
                        contentDescription = content.contentDescription,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Text(
                text = message.timestamp,
                fontSize = 12.sp
            )
        }
    }
}