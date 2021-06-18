package com.edu.austral.ingsis.app.controllers;

import com.edu.austral.ingsis.app.dtos.message.CreateMessageDTO;
import com.edu.austral.ingsis.app.dtos.message.MessageDTO;
import com.edu.austral.ingsis.app.entities.Message;
import com.edu.austral.ingsis.app.services.message.MessageService;
import com.edu.austral.ingsis.app.utils.ConnectMicroservices;
import org.springframework.http.HttpMethod;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

  private final MessageService messageService;

  public ChatController(MessageService messageService) {
    this.messageService = messageService;
  }

  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public List<MessageDTO> send(@Payload CreateMessageDTO message) {
    String token = "Bearer " + message.getToken();
    String response = ConnectMicroservices.connectToUserMicroservice("/user/logged", HttpMethod.GET, token);
    messageService.save(message, Long.parseLong(ConnectMicroservices.getFromJson(response, "id")));
    List<Message> messages = messageService.findByConversationId(message.getConversation_id());
    List<MessageDTO> messageDTOS = new ArrayList<>();
    for (Message m : messages) {
      messageDTOS.add(new MessageDTO(m.getText(), m.getReceiver_id(), m.getSender_id()));
    }
    return messageDTOS;
  }
}
