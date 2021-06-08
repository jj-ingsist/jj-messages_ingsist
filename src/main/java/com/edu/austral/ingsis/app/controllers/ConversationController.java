package com.edu.austral.ingsis.app.controllers;

import com.edu.austral.ingsis.app.dtos.conversation.ConversationDTO;
import com.edu.austral.ingsis.app.services.conversation.ConversationService;
import com.edu.austral.ingsis.app.utils.ObjectMapper;
import com.edu.austral.ingsis.app.utils.ObjectMapperImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConversationController {

  private final ConversationService conversationService;
  private final ObjectMapper objectMapper;

  public ConversationController(ConversationService conversationService) {
    this.conversationService = conversationService;
    objectMapper = new ObjectMapperImpl();
  }

  @GetMapping("/conversation/{user1}/{user2}")
  public ResponseEntity<ConversationDTO> getConversation(@PathVariable Long user1, @PathVariable Long user2) {
    return ResponseEntity.ok(objectMapper.map(conversationService.findByUsers(user1, user2), ConversationDTO.class));
  }

  @GetMapping("/conversation/{id}")
  public ResponseEntity<List<ConversationDTO>> getConversations(@PathVariable Long id) {
    return ResponseEntity.ok(objectMapper.map(conversationService.findByUser(id), ConversationDTO.class));
  }

  @PostMapping("/conversation/{user1}/{user2}")
  public ResponseEntity<ConversationDTO> saveConversation(@PathVariable Long user1, @PathVariable Long user2) {
    return ResponseEntity.ok(objectMapper.map(conversationService.save(user1, user2), ConversationDTO.class));
  }

  @DeleteMapping("/conversation/{user1}/{user2}")
  public ResponseEntity<ConversationDTO> deleteConversation(@PathVariable Long user1, @PathVariable Long user2) {
    conversationService.delete(conversationService.findByUsers(user1, user2).getId());
    return ResponseEntity.noContent().build();
  }
}
