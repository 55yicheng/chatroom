package com.example.chatroom.demos.controller;

import com.example.chatroom.demos.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/join")
    public String joinRoom(@RequestParam String roomId, @RequestParam String userId) {
        chatRoomService.joinRoom(roomId, userId);
        return "User " + userId + " joined room " + roomId;
    }

    @PostMapping("/leave")
    public String leaveRoom(@RequestParam String roomId, @RequestParam String userId) {
        chatRoomService.leaveRoom(roomId, userId);
        return "User " + userId + " left room " + roomId;
    }
}
