package com.edu.austral.ingsis.app.services.conversation;

import com.edu.austral.ingsis.app.entities.Conversation;
import com.edu.austral.ingsis.app.entities.Message;
import com.edu.austral.ingsis.app.repositories.ConversationRepository;
import com.edu.austral.ingsis.app.services.message.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

  private final ConversationRepository conversationRepository;
  private final MessageService messageService;

  public ConversationServiceImpl(ConversationRepository conversationRepository, MessageService messageService) {
    this.conversationRepository = conversationRepository;
    this.messageService = messageService;
  }

  @Override
  public Conversation save(Conversation conversation) {
    return conversationRepository.save(conversation);
  }

  @Override
  public Conversation save(Long user1, Long user2) {
    return conversationRepository.save(new Conversation(user1, user2, new ArrayList<>()));
  }

  @Override
  public Conversation findById(Long id) {
    return conversationRepository.findById(id).orElseThrow();
  }

  @Override
  public Conversation findByUsers(Long user1, Long user2) {
    return conversationRepository.findByUsers(user1, user2);
  }

  @Override
  public List<Conversation> findByUser(Long user) {
    return conversationRepository.findByUser(user);
  }

  @Override
  public void delete(Long id) {
    conversationRepository.delete(findById(id));
  }
}
