package com.edu.austral.ingsis.app.dtos.message;

public class MessageDTO {

  private String text;
  private Long receiver_id;
  private Long sender_id;

  public MessageDTO(String text, Long receiver_id, Long sender_id) {
    this.text = text;
    this.receiver_id = receiver_id;
    this.sender_id = sender_id;
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
}
