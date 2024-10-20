package com.realtime.chatapp.controllers;


import com.realtime.chatapp.services.ChatService;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private ChatService chatService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    publ
}
