package com.edu.austral.ingsis.app.services.message;

import com.edu.austral.ingsis.app.entities.Message;
import com.edu.austral.ingsis.app.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageRepository messageRepository;

  public MessageServiceImpl(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public Message save(Message message) {
    return messageRepository.save(message);
  }

  @Override
  public Message findById(Long id) {
    return messageRepository.findById(id).orElseThrow();
  }

  @Override
  public List<Message> findByConversationId(Long id) {
    return messageRepository.findByConversationId(id);
  }

  @Override
  public void delete(Long id) {
    messageRepository.delete(findById(id));
  }
}
