package com.realtime.chatapp.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime timestamp;

    @ManyToOne
    private ChatRoom chatRoom;

    @ManyToOne
    private User sender;
}
