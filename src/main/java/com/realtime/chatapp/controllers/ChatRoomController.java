package com.realtime.chatapp.controllers;


import com.realtime.chatapp.Dtos.ChatRoomDto;
import com.realtime.chatapp.services.ChatRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rooms")
public class ChatRoomController {

    private ChatRoomService chatRoomService;

    @PostMapping("/create")
    public ResponseEntity<ChatRoomDto> createRoom(@RequestBody ChatRoomDto chatRoomDto, String creatorUsername) {
        ChatRoomDto createdRoom = chatRoomService.createChatRoom(chatRoomDto, creatorUsername);

        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }
}
