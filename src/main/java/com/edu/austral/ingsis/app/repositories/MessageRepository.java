package com.edu.austral.ingsis.app.repositories;

import com.edu.austral.ingsis.app.entities.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

  @Query(value = "select m from Message m where m.conversation.id = ?1")
  List<Message> findByConversationId(Long id);
}
