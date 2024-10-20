package com.realtime.chatapp.services;


import com.realtime.chatapp.Dtos.ChatMessageDto;
import com.realtime.chatapp.models.ChatMessage;
import com.realtime.chatapp.models.ChatRoom;
import com.realtime.chatapp.repositories.ChatMessageRepository;
import com.realtime.chatapp.repositories.ChatRoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatMessageRepository chatMessageRepository;

    private ChatRoomRepository chatRoomRepository;
    @Override
    public Optional<ChatMessageDto> processMessage(ChatMessageDto chatMessageDto) {

        ChatRoom chatRoom = chatRoomRepository.findById(chatMessageDto.getChatRoomId())
                            .orElseThrow(() -> new RuntimeException("Chat room not found"));

        //convert DTO to entity
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChatRoom(chatRoom);
        chatMessage.setSender(chatMessageDto.getSender());
        chatMessage.setContent(chatMessageDto.getContent());
        chatMessage.setTimestamp(LocalDateTime.now());

        chatMessageRepository.save(chatMessage);

        //business logic for broadcast message, notification, etc



    }
}
