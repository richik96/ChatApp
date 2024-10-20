package com.realtime.chatapp.services;

import com.realtime.chatapp.Dtos.ChatRoomDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ChatRoomService {

    ChatRoomDto createChatRoom(ChatRoomDto chatRoomDto, String creatorUsername);
    List<ChatRoomDto> getAllRooms();
}
