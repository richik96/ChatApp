package com.realtime.chatapp.Dtos;

import com.realtime.chatapp.models.User;
import lombok.Data;

@Data
public class ChatMessageDto {

    private User sender;
    private String content;
    private Long chatRoomId;
}
