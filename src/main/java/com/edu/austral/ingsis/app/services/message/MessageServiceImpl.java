package com.edu.austral.ingsis.app.services.message;

import com.edu.austral.ingsis.app.dtos.message.CreateMessageDTO;
import com.edu.austral.ingsis.app.entities.Conversation;
import com.edu.austral.ingsis.app.entities.Message;
import com.edu.austral.ingsis.app.repositories.MessageRepository;
import com.edu.austral.ingsis.app.services.conversation.ConversationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageRepository messageRepository;
  private final ConversationService conversationService;

  public MessageServiceImpl(MessageRepository messageRepository, ConversationService conversationService) {
    this.messageRepository = messageRepository;
    this.conversationService = conversationService;
  }

  @Override
  public Message save(CreateMessageDTO message, Long senderId) {
    Conversation conversation = conversationService.findById(message.getConversation_id());
    Long receiverId = conversation.getUser1().equals(senderId) ? conversation.getUser2() : conversation.getUser1();
    Message saved = messageRepository.save(new Message(message.getText(), senderId, receiverId, LocalDate.now(), conversation));
    conversationService.setSeen(conversation.getId(), senderId);
    return saved;
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
