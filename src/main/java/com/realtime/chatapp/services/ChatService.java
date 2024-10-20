package com.realtime.chatapp.services;


import com.realtime.chatapp.Dtos.ChatMessageDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ChatService {

    Optional<ChatMessageDto> processMessage(ChatMessageDto chatMessageDto);
}
