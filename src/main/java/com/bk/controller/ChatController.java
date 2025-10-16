package com.bk.controller;


import com.bk.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // Handle messages sent to /app/chat
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message send(Message message) throws Exception {
        Thread.sleep(500); // Simulate processing delay
        return new Message(message.getFrom(), message.getContent());
    }
}

