package com.realtime.chatapp.services;

import com.realtime.chatapp.Dtos.UserDto;
import com.realtime.chatapp.Exceptions.ResourceNotFoundException;
import com.realtime.chatapp.Exceptions.UserAlreadyExistsException;
import com.realtime.chatapp.models.User;
import com.realtime.chatapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto registerUser(UserDto userDto) {
        Optional<User> existingUser = userRepository.findByUsername(userDto.getUsername());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with username " + userDto.getUsername() + " already exists");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);
        return userDto;  //Returning the registered user details as DTO
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with username " + username + " not found"));

        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());

        return userDto;
    }
}
