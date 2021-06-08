package com.edu.austral.ingsis.app.services.conversation;

import com.edu.austral.ingsis.app.entities.Conversation;
import com.edu.austral.ingsis.app.repositories.ConversationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

  private final ConversationRepository conversationRepository;

  public ConversationServiceImpl(ConversationRepository conversationRepository) {
    this.conversationRepository = conversationRepository;
  }

  @Override
  public void save(Long user1, Long user2) {
    if (!conversationRepository.findByUsers(user1, user2).isPresent())
      conversationRepository.save(new Conversation(user1, user2, new ArrayList<>()));
  }

  @Override
  public Conversation findById(Long id) {
    return conversationRepository.findById(id).orElseThrow();
  }

  @Override
  public Conversation findByUsers(Long user1, Long user2) {
    return conversationRepository.findByUsers(user1, user2).get();
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
