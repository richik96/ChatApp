package com.realtime.chatapp.controllers;


import com.realtime.chatapp.Dtos.ChatMessageDto;
import com.realtime.chatapp.services.ChatService;
import org.springframework.http.RequestEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private ChatService chatService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDto sendMessage(@Payload ChatMessageDto chatMessageDto) {

        //delegate the processing of the message to the chatService
        chatService.processMessage(chatMessageDto);

        //broadcasting the message to all subscribers
        return chatMessageDto;

    }
}
