package com.edu.austral.ingsis.app.services.conversation;

import com.edu.austral.ingsis.app.entities.Conversation;

import java.util.List;

public interface ConversationService {

  void save(Long user1, Long user2);

  Conversation findById(Long id);

  Conversation findByUsers(Long user1, Long user2);

  List<Conversation> findByUser(Long user);

  void delete(Long id);
}
