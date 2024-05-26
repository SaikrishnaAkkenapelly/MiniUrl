package com.miniurl.shorteningservice.listener;

import com.miniurl.shorteningservice.services.TokenCounter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/** Listener class to perform specific activities on events. */
@Component
public class ServiceEventsListener {

  private TokenCounter tokenCounter;

  public ServiceEventsListener(TokenCounter tokenCounter) {
    this.tokenCounter = tokenCounter;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onApplicationReady() {
    tokenCounter.updateCounter();
  }
}
