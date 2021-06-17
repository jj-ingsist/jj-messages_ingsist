package com.edu.austral.ingsis.app.services.conversation;

import com.edu.austral.ingsis.app.entities.Conversation;
import com.edu.austral.ingsis.app.entities.Message;
import com.edu.austral.ingsis.app.entities.MessageStatus;
import com.edu.austral.ingsis.app.repositories.ConversationRepository;
import com.edu.austral.ingsis.app.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

  private final ConversationRepository conversationRepository;
  private final MessageRepository messageRepository;

  public ConversationServiceImpl(ConversationRepository conversationRepository, MessageRepository messageRepository) {
    this.conversationRepository = conversationRepository;
    this.messageRepository = messageRepository;
  }

  @Override
  public void save(Long user1, Long user2) {
    if (conversationRepository.findByUsers(user1, user2).isEmpty())
      conversationRepository.save(new Conversation(user1, user2, new ArrayList<>()));
  }

  @Override
  public void setSeen(Long id) {
    Conversation conversation = findById(id);
    for (Message m : conversation.getMessages()) {
      m.setStatus(MessageStatus.SEEN);
      messageRepository.save(m);
    }
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
  public int getNotifications(Long id) {
    int notifications = 0;
    Conversation c = findById(id);
    for (Message m : c.getMessages()) if (!m.getStatus().equals(MessageStatus.SEEN)) notifications++;
    return notifications;
  }

  @Override
  public void delete(Long id) {
    conversationRepository.delete(findById(id));
  }
}
