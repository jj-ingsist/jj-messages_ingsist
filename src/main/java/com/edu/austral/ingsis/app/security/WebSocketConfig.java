package com.edu.austral.ingsis.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/jibber-jabber")
      .setAllowedOriginPatterns("http://localhost:3000", "http://revproxy").withSockJS()
      .setClientLibraryUrl( "https://cdn.jsdelivr.net/npm/sockjs-client@1.5.1/dist/sockjs.min.js" );
  }
  
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/conversation");
  }
}
