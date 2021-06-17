package com.edu.austral.ingsis.app.dtos.notification;

public class NotificationDTO {

  private Long conversationId;
  private int amount;

  public NotificationDTO(Long conversationId, int amount) {
    this.conversationId = conversationId;
    this.amount = amount;
  }

  public Long getConversationId() {
    return conversationId;
  }

  public void setConversationId(Long conversationId) {
    this.conversationId = conversationId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
