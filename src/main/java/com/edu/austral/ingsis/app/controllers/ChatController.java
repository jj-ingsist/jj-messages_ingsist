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

  private final List<String> strings = new ArrayList<>();

  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public String send(@Payload CreateMessageDTO message) {
    strings.add(message.getText());
    String token = "Bearer " + message.getToken();
    String response = ConnectMicroservices.connectToUserMicroservice("/user/logged", HttpMethod.GET, token);
    messageService.save(message, Long.parseLong(ConnectMicroservices.getFromJson(response, "id")));
    return message.getText();
  }

  public List<String> getMessages() {
    return strings;
  }

  public void empty() {
    strings.clear();
  }
}
