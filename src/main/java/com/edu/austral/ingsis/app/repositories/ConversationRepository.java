package com.edu.austral.ingsis.app.repositories;

import com.edu.austral.ingsis.app.entities.Conversation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {

  @Query("select c from Conversation c where (c.user1 = ?1 or c.user2 = ?1) and (c.user1 = ?2 or c.user2 = ?2)")
  Conversation findByUsers(Long user1, Long user2);

  @Query("select c from Conversation c where (c.user1 = ?1 or c.user2 = ?1)")
  List<Conversation> findByUser(Long user);
}
