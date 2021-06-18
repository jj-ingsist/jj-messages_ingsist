package com.edu.austral.ingsis.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "message")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String text;

  private Long sender_id;

  private Long receiver_id;

  private LocalDate date;

  @JsonIgnore
  @ManyToOne
  private Conversation conversation;

  public Message() {
  }

  public Message(String text, Long sender_id, Long receiver_id, LocalDate date, Conversation conversation) {
    this.text = text;
    this.sender_id = sender_id;
    this.receiver_id = receiver_id;
    this.date = date;
    this.conversation = conversation;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getSender_id() {
    return sender_id;
  }

  public void setSender_id(Long sender_id) {
    this.sender_id = sender_id;
  }

  public Long getReceiver_id() {
    return receiver_id;
  }

  public void setReceiver_id(Long receiver_id) {
    this.receiver_id = receiver_id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Conversation getConversation() {
    return conversation;
  }

  public void setConversation(Conversation conversation) {
    this.conversation = conversation;
  }
}
