package com.edu.austral.ingsis.app.dtos.message;

import java.time.LocalDate;

public class MessageDTO {

  private Long id;
  private Long sender_id;
  private Long receiver_id;
  private String text;
  private LocalDate date;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
