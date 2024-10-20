package com.realtime.chatapp.services;


import com.realtime.chatapp.Dtos.ChatMessageDto;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {

    void processMessage(ChatMessageDto chatMessageDto);
}
