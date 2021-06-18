package com.edu.austral.ingsis.app.controllers;

import com.edu.austral.ingsis.app.entities.Conversation;
import com.edu.austral.ingsis.app.services.conversation.ConversationService;
import com.edu.austral.ingsis.app.utils.ConnectMicroservices;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class NotificationController {

  private final ConversationService conversationService;

  public NotificationController(ConversationService conversationService) {
    this.conversationService = conversationService;
  }

  @GetMapping("/notifications/{id}")
  public int getNotificationsOfConversation(@RequestHeader(name = "Authorization") String token,
                                            @PathVariable Long id) {
    String response = ConnectMicroservices.connectToUserMicroservice("/user/logged", HttpMethod.GET, token);
    Long logged = Long.parseLong(ConnectMicroservices.getFromJson(response, "id"));
    Conversation conversation = conversationService.findByUsers(logged, id);
    return conversationService.getNotifications(conversation.getId(), logged);
  }
}
