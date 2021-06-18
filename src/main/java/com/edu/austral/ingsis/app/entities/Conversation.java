package com.edu.austral.ingsis.app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long user1;

  private Long user2;

  @OneToMany(mappedBy = "conversation", fetch = FetchType.EAGER, orphanRemoval = true)
  private List<Message> messages;

  private int lastSeen1;

  private int lastSeen2;

  public Conversation() {

  }

  public Conversation(Long user1, Long user2, List<Message> messages) {
    this.user1 = user1;
    this.user2 = user2;
    this.messages = messages;
  }

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

  public int getLastSeen1() {
    return lastSeen1;
  }

  public void setLastSeen1(int lastSeen1) {
    this.lastSeen1 = lastSeen1;
  }

  public int getLastSeen2() {
    return lastSeen2;
  }

  public void setLastSeen2(int lastSeen2) {
    this.lastSeen2 = lastSeen2;
  }
}
