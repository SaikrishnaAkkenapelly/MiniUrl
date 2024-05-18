package com.miniurl.shorteningservice.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.miniurl.shorteningservice.services.TokenCounter;

@Component
public class StartUpListener {

	private TokenCounter tokenCounter;

	public StartUpListener(TokenCounter tokenCounter) {
		this.tokenCounter = tokenCounter;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		tokenCounter.updateCounter();
	}

}
