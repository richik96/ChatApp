package com.realtime.chatapp.services;

import com.realtime.chatapp.Dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto registerUser(UserDto userDto);
    UserDto getUserByUsername(String username);
}
