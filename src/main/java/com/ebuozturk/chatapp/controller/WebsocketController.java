package com.ebuozturk.chatapp.controller;

import com.ebuozturk.chatapp.dto.MessagePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
@Slf4j
public class WebsocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/send_message")
    public void sendMessageToUserEndpoint(@Payload MessagePayload payload){
        log.info(String.format("%s: %s -> %s: %s",payload.getSender(),payload.getMessage(),payload.getType(),payload.getReceiver() ));
        simpMessagingTemplate.convertAndSendToUser(payload.getReceiver(),"/private",payload);
    }


}
