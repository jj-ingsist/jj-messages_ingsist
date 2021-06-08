package com.edu.austral.ingsis.app.dtos.conversation;

import com.edu.austral.ingsis.app.entities.Message;

import java.util.List;

public class ConversationDTO {

  private Long id;
  private Long user1;
  private Long user2;
  private List<Message> messages;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUser1() {
    return user1;
  }

  public void setUser1(Long user1) {
    this.user1 = user1;
  }

  public Long getUser2() {
    return user2;
  }

  public void setUser2(Long user2) {
    this.user2 = user2;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
}
