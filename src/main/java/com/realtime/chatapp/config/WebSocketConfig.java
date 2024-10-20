package com.realtime.chatapp.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

}
