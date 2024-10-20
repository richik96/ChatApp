package com.realtime.chatapp.services;

import com.realtime.chatapp.Dtos.ChatRoomDto;
import com.realtime.chatapp.Exceptions.ResourceNotFoundException;
import com.realtime.chatapp.models.ChatRoom;
import com.realtime.chatapp.models.User;
import com.realtime.chatapp.repositories.ChatRoomRepository;
import com.realtime.chatapp.repositories.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

public class ChatRoomServiceImpl implements ChatRoomService{


    private ChatRoomRepository chatRoomRepository;
    private UserRepository userRepository;
    @Override
    public ChatRoomDto createChatRoom(ChatRoomDto chatRoomDto, String creatorUsername) {
        User creator = userRepository.findByUsername(creatorUsername)
                .orElseThrow(() -> new ResourceNotFoundException("User with username " + creatorUsername + " not found"));

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(chatRoomDto.getRoomName());
        chatRoom.setCreator(creator);

        return chatRoomDto;
    }

    @Override
    public List<ChatRoomDto> getAllRooms() {
        List<ChatRoom> rooms = chatRoomRepository.findAll();

        return rooms.stream().map(room -> {
                    ChatRoomDto chatRoomDto = new ChatRoomDto();
                    chatRoomDto.setRoomName(room.getName());
                    return chatRoomDto;
                    })
                    .collect(Collectors.toList());
    }
}
