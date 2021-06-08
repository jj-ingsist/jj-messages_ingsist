package com.edu.austral.ingsis.app.controllers;

import com.edu.austral.ingsis.app.dtos.message.CreateMessageDTO;
import com.edu.austral.ingsis.app.dtos.message.MessageDTO;
import com.edu.austral.ingsis.app.entities.Message;
import com.edu.austral.ingsis.app.services.message.MessageService;
import com.edu.austral.ingsis.app.utils.ObjectMapper;
import com.edu.austral.ingsis.app.utils.ObjectMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  private final ObjectMapper objectMapper;
  private final MessageService messageService;

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  public ChatController(MessageService messageService) {
    objectMapper = new ObjectMapperImpl();
    this.messageService = messageService;
  }

  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public void send(@Payload CreateMessageDTO message) {
    MessageDTO messageDTO = objectMapper.map(messageService.save(objectMapper.map(message, Message.class)), MessageDTO.class);
    simpMessagingTemplate.convertAndSendToUser(
            messageDTO.getReceiver_id().toString(), "/secured/user/queue/specific-user", messageDTO);

  }


}
