package com.realtime.chatapp.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private User creator;
}
