package com.edu.austral.ingsis.app.dtos.message;

public class CreateMessageDTO {

  private String text;
  private Long conversation_id;
  private String token;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getConversation_id() {
    return conversation_id;
  }

  public void setConversation_id(Long conversation_id) {
    this.conversation_id = conversation_id;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
