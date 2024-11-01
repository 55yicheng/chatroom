package com.example.chatroom.demos.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ChatRoomService {

    private final Map<String, Set<String>> chatRooms = new HashMap<>();

    public void joinRoom(String roomId, String userId) {
        chatRooms.computeIfAbsent(roomId, k -> new HashSet<>()).add(userId);
        printMembers(roomId, userId);
    }

    public void leaveRoom(String roomId, String userId) {
        Set<String> members = chatRooms.get(roomId);
        if (members != null) {
            members.remove(userId);
            printMembers(roomId, userId);
        }
    }

    private void printMembers(String roomId, String userId) {
        Set<String> members = chatRooms.get(roomId);
        if (members != null) {
            System.out.println("Chat Room: " + roomId + "，成员" + userId + "加入，当前房间成员列表:");
            members.stream()
                    .forEach(System.out::println);
        }
    }
}
