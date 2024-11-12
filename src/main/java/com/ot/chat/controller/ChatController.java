package com.ot.chat.controller;


import com.ot.chat.model.Chat;
import com.ot.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;


    @MessageMapping("chat")
    @SendTo("/topic/response")
    public Chat getContent(@Payload Chat chat) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chatRepository.save(chat);
        return chat;
    }
}