package com.edu.austral.ingsis.app.services.message;

import com.edu.austral.ingsis.app.dtos.message.CreateMessageDTO;
import com.edu.austral.ingsis.app.entities.Message;

import java.util.List;

public interface MessageService {

  Message save(CreateMessageDTO message, Long senderId);

  Message findById(Long id);

  List<Message> findByConversationId(Long id);

  void delete(Long id);
}
