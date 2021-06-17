package com.edu.austral.ingsis.app.controllers;

import com.edu.austral.ingsis.app.dtos.notification.NotificationDTO;
import com.edu.austral.ingsis.app.entities.Conversation;
import com.edu.austral.ingsis.app.services.conversation.ConversationService;
import com.edu.austral.ingsis.app.utils.ConnectMicroservices;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class NotificationController {

  private final ConversationService conversationService;

  public NotificationController(ConversationService conversationService) {
    this.conversationService = conversationService;
  }

  @GetMapping("/notifications")
  public List<NotificationDTO> getNotificationsOfConversations(@RequestHeader(name="Authorization") String token) {
    String response = ConnectMicroservices.connectToUserMicroservice("/user/logged", HttpMethod.GET, token);
    List<Conversation> conversations = conversationService.findByUser(Long.parseLong(ConnectMicroservices.getFromJson(response, "id")));
    List<NotificationDTO> notifications = new ArrayList<>();
    for (Conversation c : conversations) {
      notifications.add(new NotificationDTO(c.getId(), conversationService.getNotifications(c.getId())));
    }
    return notifications;
  }
}
