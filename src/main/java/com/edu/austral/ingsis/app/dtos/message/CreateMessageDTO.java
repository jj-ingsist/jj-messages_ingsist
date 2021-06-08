package com.edu.austral.ingsis.app.dtos.message;

public class CreateMessageDTO {

  private String text;
  private Long receiver_id;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getReceiver_id() {
    return receiver_id;
  }

  public void setReceiver_id(Long receiver_id) {
    this.receiver_id = receiver_id;
  }
}
