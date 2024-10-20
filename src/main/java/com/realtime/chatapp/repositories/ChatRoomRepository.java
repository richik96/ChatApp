package com.realtime.chatapp.repositories;

import com.realtime.chatapp.models.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
