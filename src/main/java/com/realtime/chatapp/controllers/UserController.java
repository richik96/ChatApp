package com.realtime.chatapp.controllers;


import com.realtime.chatapp.Dtos.UserDto;
import com.realtime.chatapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto registeredUser = userService.registerUser(userDto);

        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }


    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        UserDto userDto = userService.getUserByUsername(username);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
