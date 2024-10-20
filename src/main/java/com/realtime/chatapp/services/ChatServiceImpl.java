package com.realtime.chatapp.services;


import com.realtime.chatapp.Dtos.ChatMessageDto;
import com.realtime.chatapp.models.ChatRoom;
import com.realtime.chatapp.repositories.ChatMessageRepository;
import com.realtime.chatapp.repositories.ChatRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatMessageRepository chatMessageRepository;

    private ChatRoomRepository chatRoomRepository;
    @Override
    public void processMessage(ChatMessageDto chatMessageDto) {

        ChatRoom chaRoom = chatRoomRepository.findById(chatMessageDto.getC
    }
}
